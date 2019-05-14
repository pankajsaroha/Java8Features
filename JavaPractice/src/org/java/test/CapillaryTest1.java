package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapillaryTest1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number");
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			System.out.println("Enter string");
			String a[] = br.readLine().split(" ");
			System.out.println(checkContent(a));
/*			if(a[1].chars().allMatch( Character::isDigit )) {
				System.out.println("N");
			}
			if(a.length == 2) {
				if(a[1].chars().allMatch( Character::isDigit )) {
					System.out.println("M");
				}
			}
			if(a.length == 3) {
				if(a[1].chars().allMatch( Character::isDigit ) && a[2].chars().allMatch( Character::isDigit )) {
					System.out.println("V");
				}
			}
*/		}
	}

	public static String checkContent(String a[]) {
		if(a[0].chars().allMatch( Character::isDigit )) {
			//System.out.println("N");
			return "N";
		}
		if(a.length == 2) {
			if(a[1].chars().allMatch( Character::isDigit )) {
				//System.out.println("M");
				return "M";
			}
		}
		if(a.length == 3) {
			if(a[1].chars().allMatch( Character::isDigit ) && a[2].chars().allMatch( Character::isDigit )) {
				//System.out.println("V");
				return "V";
			}
		}
		return "N";
	}
}
