package org.java.threading.clientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String args[]) throws IOException {
		
		ServerSocket ss = new ServerSocket(5056);
		
		while(true) {
			Socket s = null;
			try {
				s = ss.accept();
				
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				
				System.out.println("Assigning new thread for this client");
				
				Thread t = new ClientHandler(s, dis, dos);
				
				t.start();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
