package org.java.sorting;

import java.util.Scanner;

public class InsertionRecrsive {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("No of elements: ");
		int n = in.nextInt();
		System.out.print("Array : ");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		insertionRecursive(arr, n);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		in.close();
	}
		
	public static int[] insertionRecursive(int arr[], int n) {
		if(n <= 1) {
			return arr;
		}
		insertionRecursive(arr, n-1);
		int last = arr[n-1];
		int j = n-2;
		while(j>=0 && arr[j] > last) {
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = last;
		return arr;
	}
}
