package org.java.multithreading;

public class Join implements Runnable{

	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Current Thread : "+t);
		for(int i=0; i<5; i++) {
			System.out.println("Thread"+Thread.currentThread().getName());
		}
		System.out.println("Is Alive ? "+t.isAlive());
	}
	
	public static void main(String args[]) throws InterruptedException {
		Thread t1 = new Thread(new Join());
		t1.start();
		t1.join(2000);
		
		Thread t2 = new Thread(new Join());
		t2.start();
		t2.join();
		
		System.out.println("Joining after 1 sec ");
		System.out.println("Main Thread : "+t1.getName());
		
		System.out.println("Is Main Alive ? "+t1.isAlive());
		
System.out.println("Main Thread : "+t2.getName());
		
		System.out.println("Is Main Alive ? "+t2.isAlive());
	}
}
