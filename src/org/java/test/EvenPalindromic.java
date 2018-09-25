package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EvenPalindromic {

	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("test cases : ");
		//int t = Integer.parseInt(br.readLine());
		long t = Long.parseLong(br.readLine());
		
		for(long test=0; test<t; test++) {
			System.out.print("n value for nth palindrom :");
			//int n = Integer.parseInt(br.readLine());
			long n = Long.parseLong(br.readLine());
			String palindromValue = evenLengthPalindrom(n);
			//int palin[] = new int[palindromValue.length()];
			long palin[] = new long[palindromValue.length()];
			
			//Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			Map<Long, Integer> m = new HashMap<Long, Integer>();
			
			for(long i=0; i<palindromValue.length(); i++) {
				palin[(int) i] = palindromValue.charAt((int) i) - '0';
				
				if(m.containsKey(palin[(int) i])) {
					m.put(palin[(int) i], m.get(palin[(int) i])+1);
				} else {
					m.put(palin[(int) i], 1);
				}
			}
			
			long max = 0;
			Long ans = (long) 0;
			
			//int min = Collections.min(Arrays.asList(palin));
			for(Entry<Long, Integer> entry : m.entrySet()) {
				long val = entry.getValue();
				if(val > max) {
					max = val;
					ans = entry.getKey();
				}
				if (val == max) {
					Long key = entry.getKey();
					if(key < ans)
					 	ans = key;
				}
			}
			
			System.out.println(ans);
			
		}
	}
	
	static String evenLengthPalindrom(long n) {
		//String len = Integer.toString(n);
		String len = Long.toString(n);
		
		String r = len;
		
		for(long  i = len.length()-1; i>=0; --i) {
			r = r + len.charAt((int) i);
		}
		return r;
	}
	
	
}
