package org.java.searching;

import java.util.Scanner;

public class IntepolationSearch {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("No of elements :");
		int n = in.nextInt();
		System.out.print("Array :");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.print("Element to search :");
		int element = in.nextInt();
		int index = interpolationSearch(arr, element, 0, arr.length-1);
		if(index == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element is at "+index);
		}
	}
	
	public static int interpolationSearch(int arr[], int element, int l, int h) {
		if(l==h && element == arr[l]) {
			return l;
		}
		
		if(l<h) {
			//int pos = l + (((h-l)/(arr[h] - arr[l])) * (element-arr[l]));
			int pos = l + ((h - l) * (element - arr[l])) / (arr[h] - arr[l]);
			if(arr[pos] == element) {
				return pos;
			} else if(arr[pos] > element) {
				return interpolationSearch(arr, element, l, pos-1);
			} else if(arr[pos] < element ) {
				return interpolationSearch(arr, element, pos+1, h);
			} else {
				return -1;
			}
		}
		return -1;
	}
}
