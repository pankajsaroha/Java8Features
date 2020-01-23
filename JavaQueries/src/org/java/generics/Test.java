package org.java.generics;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Test {

	public static void main(String args[]) {
		int a = 12;
		String b = Integer.toString(a);
		System.out.println(b);
		
		@SuppressWarnings("rawtypes")
		ArrayList al = new ArrayList();
		al.add("Pankaj");
		al.add("Kumar");
		al.add(23);
		al.add(1, "Saroha");
		
		String name = (String) al.get(0);
		String lname = (String) al.get(1);
		String age = (String) al.get(2);
		
		System.out.println(name+" "+ lname+" "+ age);
	}
}
