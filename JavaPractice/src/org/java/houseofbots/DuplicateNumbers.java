package org.java.houseofbots;

import java.util.Scanner;

public class DuplicateNumbers {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		DuplicateNumbers d = new DuplicateNumbers();
		int a[] = d.removeDuplicates(arr, 0);
		for(int i : a) {
			System.out.print(i+" ");
		}
		in.close();
	}
	
	public int[] removeDuplicates(int arr[], int j) {
		int count = 0;
		while(j<arr.length) {
			int item = arr[j];
			for(int i=j+1; i<arr.length; i++) {
				if(item == arr[i] && item != -1) {
					arr[i] = -1;
					count++;
				}
			}
			j++;
		}
		int a[] = new int[arr.length-count];
		int k = 0;
		for(int i : arr) {
			if(i != -1) {
				a[k] = i;
				k++;
			}
		}
		return a;
	}
}
