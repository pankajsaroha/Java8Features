package org.java.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class OracleString {
	
	String val = "";
	
	OracleString (String val) {
		this.val = val;
	}

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(new HelloWorld().hashCode());
		/*Map<HelloWorld, Integer> map = new HashMap<>();
		map.put(new HelloWorld(), 1);
		map.put(new HelloWorld(), 2);*/
		OracleString or = new OracleString("Pankaj");
		OracleString or1 = new OracleString("Pankaj");
		System.out.println(or+" "+or1);
		System.out.println(or == or1);
		System.out.println(or.equals(or1));
		String s = new String("Pankaj");
		String s1 = new String("Pankaj");
		System.out.println(s+" "+s1);
		System.out.println(s == s1);
		s.equals(s1);
		or.equals(or1);
		String str = br.readLine();
		str = reverse(str);
		System.out.println(str);
		String arr[] = str.split(" ");
		String ar[] = new String[arr.length];
		for(int i=0, j=arr.length-1; i<arr.length && j>=0; i++, j--) {
			ar[j] = arr[i];
		}
		System.out.println(Arrays.toString(ar));
		int k = 0;
		StringBuilder res = new StringBuilder();
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar[i].length(); j++) {
				if(str.charAt(k) == ' ') {
					k++;
				}
				res.append(str.charAt(k));
				k++;
			}
			res.append(' ');
		}
		System.out.println(res.toString().trim());
	}
	
	public static String reverse(String str) {
		StringBuilder st = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--) {
			st.append(str.charAt(i));
		}
		return st.toString();
	}
}
