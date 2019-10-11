package org.java.multithreading;

import java.util.Scanner;

public class PC {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Produce thread running...");
			wait();
			System.out.println("Resumed");
		}
	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		Scanner s = new Scanner(System.in);
		synchronized(this) {
			System.out.println("Consume thread running...");
			s.nextLine();
			System.out.println("Return key pressed");
			notify();
			Thread.sleep(2000);
			System.out.println("Consume finished..");
		}
		s.close();
	}
}
