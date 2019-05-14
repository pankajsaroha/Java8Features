package org.java.houseofbots;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StringQuestions {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StringQuestions strQues = new StringQuestions();
		String str = in.next();
		//strQues.removeDuplicateChars(str);
		//strQues.removeDuplicateCharsUsingMap(str);
		//System.out.println(str);
		//strQues.checkAnagrams(str, in.next());
		//strQues.nonRepeatedCharUsingMap(str, 1);
		//System.out.println(strQues.reversed(str));
		//strQues.reversedIterative(str);
		//strQues.vowelConsonantsCount(str);
		//strQues.occurrence(str, in.next().charAt(0));
		//strQues.permutation(str);
		//System.out.println(strQues.checkRotation(str, in.next()));
		//strQues.reverseSentence(in.nextLine());
		System.out.println(strQues.palindrom(str));
		in.close();
	}
	
	public void removeDuplicateChars(String str) {
		StringBuilder sb = new StringBuilder(str);
		int i = 0;
		System.out.print("Duplicate Characters - ");
		while(i<sb.length()) {
			if(sb.substring(i+1).indexOf(sb.charAt(i)) != -1) {
				System.out.print(sb.charAt(i));
				sb.deleteCharAt(sb.indexOf(String.valueOf(sb.charAt(i)))+sb.substring(i+1).indexOf(sb.charAt(i))+1);
			} else {
				i++;
			}
		}
		System.out.println();
		System.out.println(sb.toString());
	}
	
	public void removeDuplicateCharsUsingMap(String str) {
		Map<Character, Integer> map = new HashMap<>();
		System.out.print("Duplicate Characters (Using Map) - ");
		for(int i=0; i<str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
				System.out.print(str.charAt(i));
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		System.out.println();
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey());
		}
		System.out.println();
	}
	
	public void checkAnagrams(String str1, String str2) {
		if(str1.length() != str2.length()) {
			System.out.println("Strings are not anagram");
		} else {
			char c2[] = str2.toLowerCase().toCharArray();
			char c1[] = str1.toLowerCase().toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			if(String.valueOf(c1).equals(String.valueOf(c2))) {	// or Arrays.equals(c1, c2);
				System.out.println("Strings are anagram");
			} else {
				System.out.println("Strings are not anagram");
			}
			
		}
	}
	
	public boolean isAnagram(String word, String anagram){
        if(word.length() != anagram.length()){
            return false;
        }
        char[] chars = word.toCharArray();
        for(char c : chars){
            int index = anagram.indexOf(c);
            if(index != -1){
                anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length());
            }else{
                return false;
            }
        } 
        return anagram.isEmpty();
    }
	
	public void nonRepeatedCharacter(String str, int n) {
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(!str.substring(0, i).contains(String.valueOf(str.charAt(i))) && !str.substring(i+1).contains(String.valueOf(str.charAt(i)))) {
				if(++count == n) {
					System.out.println(str.charAt(i));
					return;
				}
			}
		}
	}
	
	public void nonRepeatedCharUsingMap(String str, int n) {
		int count = 0;
		Map<Character, Integer> map = new LinkedHashMap<>();
		for(int i=0; i<str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				if(++count == n) {
					System.out.println(entry.getKey());
				}
			}
		}
	}
	
	/* Recursive Approach */
	public String reversed(String str) {
		
		if(str.length() < 2) {
			return str;
		}
		return reversed(str.substring(1)) + str.charAt(0);
	}
	
	public void reversedIterative(String str) {
		char c[] = str.toCharArray();
		for(int i=0, j=c.length-1; i<=j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		System.out.println(String.valueOf(c));
	}
	
	public void vowelConsonantsCount(String str) {
		int vowels = 0;
		int cons = 0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
				vowels++;
			} else {
				cons++;
			}
		}
		System.out.println("Vowels : "+vowels+", Consonants : "+cons);
	}
	
	public void occurrence(String str, char c) {
		String s = str.replaceAll("[^"+c+"]", "");
		System.out.println(s.length());
	}
	
	public void permutation(String str) {
		List<String> list = new ArrayList<>();
		System.out.println(permutation(list, "", str));
	}
	
	private List<String> permutation(List<String> permutations, String perm, String str) {
		if(str.isEmpty()) {
			permutations.add(perm+str);
		} else {
			for(int i=0; i<str.length(); i++) {
				permutation(permutations, perm+str.charAt(i), str.substring(0, i)+str.substring(i+1));
			}
		}
		return permutations;
	}
	
	/*Check if two strings are a rotation of each other*/
	public boolean checkRotation(String str1, String str2) {
		boolean flag = false;
		String str = str1.concat(str1);
		if(str.contains(str2)) {
			flag = true;
		}
		return flag;
	}
	
	public void reverseSentence(String str) {
		String words[] = str.trim().split("\\s");
		for(int i=0, j=words.length-1; i<=j; i++, j--) {
			String temp = words[i];
			words[i] = words[j];
			words[j] = temp;
		}
		
		Arrays.stream(words).map(x -> x+" ").forEach(y -> System.out.print(y));
	}
	
	public boolean checkPalindrom(String str) {
		boolean flag = true;
		char c[] = str.toCharArray();
		for(int i=0, j=c.length-1; i<j; i++, j--) {
			if(c[i] != c[j]) {
				flag = false;
				return flag;
			}
		}
		return flag;
	}
	
	public boolean palindrom(String str) {
		boolean flag = false;
		String reverse = reversed(str);
		if(reverse.equals(str)) {
			flag = true;
		}
		return flag;
	}
}
