package org.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EspilonTest3 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("No of testcases");
		int t = in.nextInt();
		for (int test = 0; test < t; test++) {
			System.out.println("Word ");
			String word = in.next();
			word = word.replaceAll("[bcdfghjklmnpqrstvwxyz]", "");
			word = removeDuplicates(word);
			if (word.equals("")) {
				System.out.println("Good");
			} else {
				if (word.length() == 1) {
					System.out.println("Good");
				} else {
					List<Integer> list = new ArrayList<>();
					for (int i = 0; i < word.length() - 1; i++) {
						for (int j = i + 1; j < word.length(); j++) {
							if (word.charAt(i) <= word.charAt(j)) {
								list.add(0);
							} else {
								list.add(1);
							}
						}
						if (list.contains(0) && list.contains(1)) {
							break;
						}
					}

					if (list.contains(0) && list.contains(1)) {
						System.out.println("Bad");
					}
					if (list.contains(0) && !list.contains(1)) {
						System.out.println("Good");
					}
					if (list.contains(1) && !list.contains(0)) {
						System.out.println("Worst");
					}
				}
			}
		}
	}

	static String removeDuplicates(String word) {
		StringBuilder sb = new StringBuilder(word);
		int i = 0;
		while (i < sb.length() - 1) {
			if (sb.charAt(i) == sb.charAt(i + 1)) {
				sb.deleteCharAt(i + 1);
			} else {
				i++;
			}
		}
		return sb.toString();
	}
}
