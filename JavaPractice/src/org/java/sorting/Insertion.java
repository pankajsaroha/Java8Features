package org.java.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Insertion {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Insertion insert = new Insertion();
		System.out.print("Enter size : ");
		int n = in.nextInt();
		System.out.print("Enter elements : ");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		insert.insertion(arr, n);
		System.out.println(Arrays.toString(arr));
		in.close();
	}
	
	/*void insertion(int arr[]) {
		for(int i=1; i<arr.length; i++) {
			System.out.println("Iteration"+i);
			for(int j=0; j<i; j++) {
				if(arr[j]>arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
				System.out.println("Array : "+Arrays.toString(arr));
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}*/
	
	void insertion(int arr[], int n) {
		for(int i=1; i<n; i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	void insertionRecursive(int arr[], int n) {
		if(n==1)
			return;
		
		insertionRecursive(arr, n-1);
		
		int last = arr[n-1];
		int j = n-2;
		
		while(j>=0 && arr[j]>last) {
			arr[j+1] = arr[j];
			j = j-1;
		}
		arr[j+1] = last;
	}
}
