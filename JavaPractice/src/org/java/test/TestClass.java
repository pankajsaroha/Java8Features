package org.java.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TestClass {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = null;
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String a[] = br.readLine().split(" ");
		for (int i = 0; i < a.length; i++) {
			arr[i] = Integer.parseInt(a[i]);
		}
		sort(arr);
		print(arr);
	}

	public static void sort(int arr[]) {
		int n = arr.length;
		
		for(int i = n/2 -1; i>=0; i--) {
			heapify(arr, n, i);
		}
		
		for(int i=n-1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
		}
	}
	
	public static void heapify(int arr[], int n, int i) {
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		int largest = i;
		
		if(left < n && arr[largest] < arr[left]) {
			largest = left;
		}
		
		if(right < n && arr[largest] < arr[right]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr, n, largest);
		}
	}
	
	public static void print(int arr[]) {
		for(Integer i : arr) {
			System.out.print(i + " ");
		}
	}
}