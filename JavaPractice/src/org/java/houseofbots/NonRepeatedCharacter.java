package org.java.houseofbots;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NonRepeatedCharacter {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = in.nextInt();
		NonRepeatedCharacter nrc = new NonRepeatedCharacter();
		System.out.println(nrc.nonRepeatedCharacterByMap(s, n));
		in.close();
	}
	
	public String nonRepeatedCharacter(String str, int n) {
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(!str.substring(0, i).contains(String.valueOf(str.charAt(i))) && !str.substring(i+1).contains(String.valueOf(str.charAt(i)))) {
				if(++count == n) {
					return String.valueOf(str.charAt(i));
				}
			}
		}
		return "No non-repeated character";
	}
	
	public String nonRepeatedCharacterByMap(String str, int n) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for(char c : str.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}

		int count = 0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1 && ++count == n) {
				return String.valueOf(entry.getKey());
			}
		}
		return "No non-repeated character";
	}
}
