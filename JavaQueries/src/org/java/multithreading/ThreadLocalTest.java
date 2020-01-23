package org.java.multithreading;

public class ThreadLocalTest {
	static int var = 5;
	static ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 5;
		}
	};
	public static void main(String args[]) {
		Thread t1 = new Thread(new Runnable() {
	
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					tl.set(tl.get() + 1);
					var = var + 1;
					System.out.println("Thread 1 : " + tl.get());
					System.out.println("Thread 1 var : " + var);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	
		Thread t2 = new Thread(new Runnable() {
	
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					tl.set(tl.get() + 1);
					var = var + 1;
					System.out.println("Thread 2 : " + tl.get());
					System.out.println("Thread 2 var : " + var);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t1.start();
		t2.start();
	}
}
