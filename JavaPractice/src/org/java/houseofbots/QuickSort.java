package org.java.houseofbots;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		QuickSort quick = new QuickSort();
		quick.quickSort(arr, 0, arr.length - 1);
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		in.close();
	}

	private void quickSort(int input[], int low, int high) {
		int i = low;
		int j = high;
		int pivot = input[low + (high - low) / 2];
		 
		while (i <= j) {
			while (input[i] < pivot) {
				i++; 
			}
			while (input[j] > pivot) {
				j--; 
			}
			if(i<=j) {
				swap(input, i, j);
				i++;
				j--;
			}
		}
		
		if (low < j) {
			quickSort(input, low, j);
		}
		if (i < high) {
			quickSort(input, i, high);
		}
	}	
	
	public int[] swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
}
