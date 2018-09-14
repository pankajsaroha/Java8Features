package org.java.searching;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("No of elements");
		int n = in.nextInt();
		System.out.println("Array :");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("element to search");
		int element = in.nextInt();
		for(int i=0; i<n; i++) {
			if(arr[i] == element) {
				System.out.println("Element is at index "+ i);
				break;
			}
		}
	}
}
