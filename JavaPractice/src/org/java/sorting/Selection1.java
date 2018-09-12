package org.java.sorting;

import java.util.Scanner;

public class Selection1 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("No of elements :");
		int n = in.nextInt();
		System.out.println("Array : ");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		selectionSort(arr);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static int[] selectionSort(int arr[]) {
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int minIndex = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		
		return arr;
	}
}
