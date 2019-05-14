package org.java.test;

import java.util.Scanner;

public class Cars24_02 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter test cases : ");
		int t = in.nextInt();
		for(int test = 0; test < t; test++) {
			System.out.println("Enter n :");
			int n = in.nextInt();
			//int arr[] = new int[n];
			int sum = 0;
			for(int i=0; i<n; i++) {
				sum = sum+in.nextInt();
			}
			if(sum%n == 0) {
				System.out.println(sum/n);
			} else {
				System.out.println(-1);
			}
		}
	}
}
