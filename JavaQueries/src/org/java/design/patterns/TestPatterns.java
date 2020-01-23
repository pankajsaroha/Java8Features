package org.java.design.patterns;

import java.lang.reflect.Constructor;

class GetThread implements Runnable {
	Singleton s1;

	@Override
	public void run() {
		s1 = Singleton.getInstance();
		System.out.println("Instance : " + s1.hashCode());
	}

}

public class TestPatterns {

	public static void main(String[] args) {
		Thread t1 = new Thread(new GetThread());
		Thread t2 = new Thread(new GetThread());
		Thread t3 = new Thread(new GetThread());
		Thread t4 = new Thread(new GetThread());
		Thread t5 = new Thread(new GetThread());
		Thread t6 = new Thread(new GetThread());
		Thread t7 = new Thread(new GetThread());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();

		Singleton s1 = Singleton.getInstance();
		Singleton s2 = null;

		try {
			Constructor<?> constructors[] = Singleton.class.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				constructor.setAccessible(true);
				s2 = (Singleton) constructor.newInstance();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}
