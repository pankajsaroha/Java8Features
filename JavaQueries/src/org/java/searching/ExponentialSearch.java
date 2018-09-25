package org.java.searching;

import java.util.Arrays;
import java.util.Scanner;

public class ExponentialSearch {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("No of elements: ");
		int n = in.nextInt();
		System.out.print("Array :");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Element to search :");
		int element = in.nextInt();
		int index = exponentialSearch(arr, arr.length, element);
		System.out.println((index < 0) ? 
				"Element is not present in the array" :
					"Element is present ar index " + index);
	}
	
	public static int exponentialSearch(int arr[], int n, int element) {
		if(arr[0] == element) {
			return 0;
		}
		int i=1;
		while(i < n && arr[i] <= element) {
			i = i*2;
		}
		return Arrays.binarySearch(arr, i/2, Math.min(i, n), element);
	}
}
