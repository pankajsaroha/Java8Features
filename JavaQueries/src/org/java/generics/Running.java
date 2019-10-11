package org.java.generics;

public class Running {

	public static void main(String args[]) {
		BoxTest<String, Integer> box = new BoxTest<String, Integer>("Pankaj", 23);
		
		//box.setT(12);
		System.out.println(box.getT());
		//box.setT(10);
		System.out.println(box.getS());
	}
}
