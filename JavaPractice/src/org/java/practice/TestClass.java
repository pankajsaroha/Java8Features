package org.java.practice;

import java.util.ArrayList;
import java.util.List;

public class TestClass{
	
	static List<String> list = new ArrayList<>();
	
	public static void main(String args[]) {
		String s = "123";
		//getSubsequences(s, "");
		for(int i=0; i<8; i++) {
			String index = String.format("%3s",Integer.toBinaryString(i)).replace(' ', '0');
			String ans = "";
			for(int j=0; j<index.length(); j++) {
				if("1".equals(""+index.charAt(j))) {
					ans += s.charAt(j);
				}
			}
			list.add(ans);
		}
		System.out.println(list);
	}
	
	public static void getSubsequences(String s, String p) {
		if(s.length() == 0) {
			System.out.println(p);
			return;
		}
		getSubsequences(s.substring(1), p);
		getSubsequences(s.substring(1), p+s.charAt(0));
	}
	
}