package org.java.test;

public class Running implements Cloneable{

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	String s = "Clonning Example";
	
	public static void main(String args[]) throws CloneNotSupportedException {
		Running r = new Running();
		Running rc = (Running) r.clone();
		System.out.println(rc.s);
	}
}
