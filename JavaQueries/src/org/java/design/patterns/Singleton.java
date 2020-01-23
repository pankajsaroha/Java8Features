package org.java.design.patterns;

public class Singleton {

	private static Singleton instance;
	private static Object mutex = new Object();

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (mutex) {
				if(instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
}