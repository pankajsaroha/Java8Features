package org.java.multithreading;

public class Count extends Thread{

	Count() {
		System.out.println("Thread about to run");
		System.out.println("Thread created "+ this);
		start();
	}
	
	public void run() {
		try {
			for(int i=0; i<5; i++) {
				System.out.println("Printing the count "+i);
				Thread.sleep(1000);
			}
		}catch (InterruptedException e) {
			System.out.println("Thread interrupted...");
		}
		System.out.println("Thread Over!!!");
	}
}
