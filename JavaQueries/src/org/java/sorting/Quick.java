package org.java.sorting;

import java.util.Scanner;

public class Quick {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Quick q = new Quick();
		System.out.print("Enter size : ");
		int n = in.nextInt();
		int arr[] = new int[n];
		System.out.print("Enter elements : ");
		for(int i=0; i<n; i++)
			arr[i] = in.nextInt();
		q.quick(arr, 0, n-1);
		q.printArray(arr);
		in.close();
	}
	
	void quick(int arr[], int low, int high) {
		if(low<high) {
			int pi = partition(arr, low, high);
			
			quick(arr, low, pi-1);
			quick(arr, pi+1, high);
		}
	}
	
	int partition(int arr[], int low, int high) {
		
		int pivot = high;
		int i = low-1;
		for(int j=low; j<high; j++) {
			if(arr[j] <= arr[pivot]) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, high);
		return i+1;
	}
	
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	void printArray(int[] arr) {
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
