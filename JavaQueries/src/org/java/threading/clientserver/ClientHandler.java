package org.java.threading.clientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler extends Thread {

	DateFormat forDate = new SimpleDateFormat("yyyy/MM/dd");
	DateFormat forTime = new SimpleDateFormat("hh:mm:ss");
	final DataInputStream dis;
	final DataOutputStream dos;
	final Socket s;

	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
		this.s = s;
		this.dis = dis;
		this.dos = dos;
	}

	@Override
	public void run() {
		String received;
		String toReturn;
		while (true) {
			try {
				// Ask user what he wants
				dos.writeUTF("What do you want?[Date | Time]..\n" + "Type Exit to terminate");

				// receive the answer from client
				received = dis.readUTF();

				if (received.equals("Exit")) {
					System.out.println("Client " + this.s + " sends exit...");
					System.out.println("Closing the connection");
					this.s.close();
					System.out.println("Connection closed...");
					break;
				}

				Date date = new Date();

				switch (received) {
				case "Date":
					toReturn = forDate.format(date);
					dos.writeUTF(toReturn);
					break;

				case "Time":
					toReturn = forTime.format(date);
					dos.writeUTF(toReturn);
					break;

				default:
					dos.writeUTF("Invalid Input");
					break;

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			this.dis.close();
			this.dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
