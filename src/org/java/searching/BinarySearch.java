package org.java.searching;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String args[]) {

		BinarySearch bs = new BinarySearch();
		Scanner in = new Scanner(System.in);
		System.out.println("No of elements");
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Element to be searched : ");
		int data = in.nextInt();
		int m = bs.binarySearch(arr, 0, arr.length - 1, data);
		if (m != -1) {
			System.out.println(data + " is at " + m);
		} else {
			System.out.println("Element is not found");
		}
	}

	public int binarySearch(int arr[], int l, int h, int data) {

		if (l <= h) {
			int m = (l + h + 1) / 2;
			System.out.println("m :" + m);
			if (arr[m] == data) {
				return m;
			}
			if (data < arr[m]) {
				return binarySearch(arr, l, m-1, data);
			}
			return binarySearch(arr, l, m+1, data);

		}
		return -1;
	}
}
