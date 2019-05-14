package org.java.multithreading;

public class ThreadTest {

	public static void main(String args[]) {
		Count c = new Count();
		try {
			while(c.isAlive()) {
				System.out.println("Main thread will alive till child thread is alive");
				Thread.sleep(1500);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Main thread is over");
	}
}
