package org.java.searching;
import java.util.Scanner;

public class BinarySearch2 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("No of elements: ");
		int n = in.nextInt();
		System.out.print("Array: ");
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.print("Element to search: ");
		int element = in.nextInt();
		int index = binarySearch(arr, element, 0, arr.length-1);
		if(index == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element is at "+index);
		}
		in.close();
	}
	
	public static int binarySearch(int a[], int element, int l, int h) {
		int mid = (h-l)/2;
		if(l <= h) {
			if(a[mid] == element) {
				return mid;
			}
			else if(a[mid] > element) {
				return binarySearch(a, element, l, mid-1);
			} else if(a[mid] > element){
				return binarySearch(a, element, mid+1, h);
			} else {
				return -1;
			}
		}
		return -1;
	}
}
