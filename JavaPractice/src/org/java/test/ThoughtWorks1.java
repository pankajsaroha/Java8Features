package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ThoughtWorks1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ThoughtWorks1 t = new ThoughtWorks1();
		int k = Integer.parseInt(br.readLine().trim());
		String s = br.readLine();
		int n = s.length();
		int count = 0;
		for(int i=1; i<n; i++) {
			Map<Character, Integer> first = new HashMap<>();
			Map<Character, Integer> second = new HashMap<>();
			String f = s.substring(0, i);
			String se = s.substring(i, n);
			for(int j=0; j<f.length(); j++) {
				int v = first.getOrDefault(f.charAt(j), 0);
				if(v==0) {
					first.put(f.charAt(j), 1);
				} else {
					first.put(f.charAt(j), v+1);
				}
			}
			for(int j=0; j<se.length(); j++) {
				int v = second.getOrDefault(se.charAt(j), 0);
				if(v==0) {
					second.put(se.charAt(j), 1);
				} else {
					second.put(se.charAt(j), v+1);
				}
			}
			if(t.check(first, second, k)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public boolean check(Map<Character, Integer> first, Map<Character, Integer> second, int k) {
		int kcheck = 0;
		if(first.size() > second.size()) {
			for(Entry<Character, Integer> entry : second.entrySet()) {
				if(first.containsKey(entry.getKey())) {
					if(first.get(entry.getKey()) == entry.getValue()) {
						kcheck++;
						if(kcheck == k) {
							return true;
						}
					}
				}
			}
		} else {
			for(Entry<Character, Integer> entry : first.entrySet()) {
				if(second.containsKey(entry.getKey())) {
					if(second.get(entry.getKey()) == entry.getValue()) {
						kcheck++;
						if(kcheck == k) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
