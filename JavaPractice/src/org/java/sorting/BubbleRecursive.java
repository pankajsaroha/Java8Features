package org.java.sorting;

import java.util.Scanner;

public class BubbleRecursive {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("No of elements");
		int n = in.nextInt();
		System.out.println("Array");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		recursiveBubble(arr, n);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
 		in.close();
	}
	
	public static int[] recursiveBubble(int arr[], int n) {
		if(n == 1) {
			return arr;
		}
		for(int i=0; i<n-1; i++) {
			if(arr[i] > arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		return recursiveBubble(arr, n-1);
	}
}
