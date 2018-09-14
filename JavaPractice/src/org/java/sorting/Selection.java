package org.java.sorting;

import java.util.Scanner;

public class Selection {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size : ");
		int n = in.nextInt();
		System.out.println("Enter elements : ");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		printArray(selection(arr));
		in.close();
	}
	
	public static int[] selection(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int min = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			/*int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;*/
			swap(arr, min, i);
		}
		return arr;
	}
	
	public static void swap(int[] arr, int min, int i) {
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
	
	public static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
