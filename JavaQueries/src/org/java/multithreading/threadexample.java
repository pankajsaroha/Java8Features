package org.java.multithreading;

public class threadexample {

	public static void main(String args[]) throws InterruptedException {
		final PC pc = new PC();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					pc.produce();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					pc.consume();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("1 -- T1 alive: "+t1.isAlive()+"T2 Alive: "+t2.isAlive());
		t1.start();
		System.out.println("2 -- T1 alive: "+t1.isAlive()+"T2 Alive: "+t2.isAlive());
		t2.start();
		System.out.println("3 -- T1 alive: "+t1.isAlive()+"T2 Alive: "+t2.isAlive());
		t1.join();
		System.out.println("4 -- T1 alive: "+t1.isAlive()+"T2 Alive: "+t2.isAlive());
		t2.join();
		System.out.println("5 -- T1 alive: "+t1.isAlive()+"T2 Alive: "+t2.isAlive());
	}
}
