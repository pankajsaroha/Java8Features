package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hitachi {

	public static void  main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String p = br.readLine();
		StringBuilder str = new StringBuilder(s);
		int i = 0;
		while(i < str.length()) {
			int oldPos = p.indexOf(str.charAt(i));
			int newPos = (int) (Math.pow(2, oldPos) % 26);
			str.setCharAt(i, p.charAt(newPos));
			i++;
		}
		System.out.println(str.toString());
	}
	
	
}