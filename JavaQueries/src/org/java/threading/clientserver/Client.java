package org.java.threading.clientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String args[]) throws IOException {

		try {
			Scanner in = new Scanner(System.in);

			InetAddress ip = InetAddress.getByName("localhost");

			Socket s = new Socket(ip, 5056);

			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());

			while (true) {
				System.out.println(dis.readUTF());
				String toSend = in.nextLine();
				dos.writeUTF(toSend);

				if (toSend.equals("Exit")) {
					System.out.println("Closing these connection : " + s);
					s.close();
					System.out.println("Connection closed");
					break;
				}

				String received = dis.readUTF();
				System.out.println(received);
			}

			in.close();
			dis.close();
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
