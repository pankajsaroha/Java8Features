package org.java.sorting;

import java.util.Scanner;

public class Insertion1 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("No of elements : " );
		int n = in.nextInt();
		System.out.print("Array : ");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		insertionSort(arr);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		in.close();
	}
	
	public static int[] insertionSort(int arr[]) {
		int n = arr.length;
		for(int i=1; i<n; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		return arr;
	}
}
