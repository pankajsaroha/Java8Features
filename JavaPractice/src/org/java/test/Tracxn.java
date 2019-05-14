package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tracxn {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String temp = "";
		boolean flag = true;
		int count = 0;
		int i = 1;

		ArrayList<Character> list = new ArrayList<>();
		
		list.add(str.charAt(0));
		while(i<str.length()) {
			char c = str.charAt(i);
			if(list.contains(c)) {
				list.add(c);
			} else {
				if(list.size()%2 == 0) {
					String s = getStringRepresentation(list);
					str = str.replaceFirst(s, "");
					i=0;
				}
				list = new ArrayList<>();
			}
			i++;
			if(list.isEmpty()) {
				list.add(str.charAt(i-1));
			}
		}
		if(list.size()%2 == 0) {
			String s = getStringRepresentation(list);
			str = str.replaceFirst(s, "");
		}
		if(str.isEmpty()) {
			System.out.println("Nothing");
		} else {
			System.out.println(str);
		}
	}
	
	static String getStringRepresentation(ArrayList<Character> list)
	{    
	    StringBuilder builder = new StringBuilder(list.size());
	    for(Character ch: list)
	    {
	        builder.append(ch);
	    }
	    return builder.toString();
	}

}
