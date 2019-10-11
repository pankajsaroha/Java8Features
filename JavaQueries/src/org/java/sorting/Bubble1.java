package org.java.sorting;

import java.util.Scanner;

public class Bubble1 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("No of elements : ");
		int n = in.nextInt();
		System.out.print("Array : ");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		bubbleSort(arr);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static int[] bubbleSort(int arr[]) {
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
}
