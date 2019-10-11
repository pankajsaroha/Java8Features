package org.java.sorting;

import java.util.Scanner;


public class Merge {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Merge mrg = new Merge();
		System.out.print("Enter size : ");
		int n = in.nextInt();
		int arr[] = new int[n];
		System.out.print("Enter elements : ");
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		mrg.sort(arr, 0, n-1);
		mrg.printArray(arr);
		in.close();
	}
	
	void sort(int arr[], int l, int r) {
		if(l<r) {
			int m=(l+r)/2;
			
			sort(arr, l, m);
			sort(arr, m+1, r);
			
			mergeSort(arr, l, m, r);
		}
	}
	
	void mergeSort(int arr[], int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		
		int leftTemp[] = new int[n1];
		int rightTemp[] = new int[n2];
		
		for(int i=0; i<n1; i++)
			leftTemp[i] = arr[l+i];
		for(int j=0; j<n2; j++)
			rightTemp[j] = arr[m+1+j];
		
		int i=0, j=0;
		int k=l;
		
		while(i<n1 && j<n2) {
			if(leftTemp[i] <= rightTemp[j]) {
				arr[k] = leftTemp[i];
				i = i+1;
			} else {
				arr[k] = rightTemp[j];
				j = j+1;
			}
			k++;
		}
		while(i<n1) {
			arr[k] = leftTemp[i];
			i++;
			k++;			
		}
		while(j<n2) {
			arr[k] = rightTemp[j];
			j++;
			k++;
		}
	}
	
	void printArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
