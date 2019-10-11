package org.java.sorting;

import java.util.Scanner;

public class MergeRecursive {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		MergeRecursive merge = new MergeRecursive();
		System.out.print("Enter size: ");
		int n = in.nextInt();
		System.out.print("Enter elements : ");
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = in.nextInt();
		merge.mergeSort(arr);
		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
		in.close();
	}
	
	void mergeSort(int[] arr) {
		if(arr == null)
			return;
		if(arr.length > 1) {
			int m = arr.length/2;
			
			int left[] = new int[m];
			for(int i=0; i<m; i++)
				left[i] = arr[i];
			int right[] = new int[arr.length-m];
			for(int i=0; i<arr.length-m; i++)
				right[i] = arr[i+m];
			
			mergeSort(left);
			mergeSort(right);
			
			int i=0, j=0, k=0;
			
			while(i<left.length && j<right.length) {
				if(left[i] < right[j]) {
					arr[k] = left[i];
					i++;
					k++;
				}else {
					arr[k] = right[j];
					j++;
					k++;
				}
			}
			while(i<left.length) {
				arr[k] = left[i];
				k++;
				i++;
			}
			while(j<right.length) {
				arr[k] = right[j];
				k++;
				j++;
			}
		}
	}
}
