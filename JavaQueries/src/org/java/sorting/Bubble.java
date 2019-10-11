package org.java.sorting;

import java.util.Scanner;

public class Bubble {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size : ");
		int n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter elements : ");
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		int a[] = bubble(arr, n);		//OR bubbleRecursive(arr, n);
		for(int i=0; i<n; i++) {
			System.out.print(a[i]+" ");
		}
		in.close();
	}
	
	public static int[] bubble(int[] arr, int size) {
		for(int j=size-1; j>=0; j--) {
			for(int i=0; i<=j-1; i++) {
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static int[] bubbleRecursive(int arr[], int n) {
		
		if(n==1)
			return arr;
		for(int i=0; i<n-1; i++) {
			if(arr[i]>arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		bubbleRecursive(arr, n-1);
		return arr;
	}
}
