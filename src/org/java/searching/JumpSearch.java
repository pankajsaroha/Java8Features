package org.java.searching;

import java.util.Scanner;

public class JumpSearch {

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
		int index = jumpStart(arr, element);
		if(index == -1) {
			System.out.println("Element not found.");
		} else {
			System.out.println("Element is at "+index);
		}
		in.close();
	}
	
	public static int jumpStart(int a[], int element) {
		int len = a.length;
		int step = (int) Math.floor(Math.sqrt(len));
		int stepItr = step;
		int prev = 0;
		/*for(int i=0; i<len; i=i+step) {
			if(a[i] == element) {
				return i;
			} else if(a[i] > element) {
				int count = 0;
				for(int j=prev; j<i; j++) {
					if(a[j] == element) {
						return prev+count;
					}
					count++;
				}
				return -1;
			} else if(a[i] < element && i>0) {
				prev = step+prev;
			}
		}*/
		
		while(a[Math.min(step, len)-1] < element) {
			prev = step;
			step = step+stepItr;
			if(prev >= len ) {
				return -1;
			}
		}
		
		while(a[prev] < element) {
			prev++;
			if(prev == Math.min(step, len)) {
				return -1;
			}
		}
		
		if(a[prev]  == element ) {
			return prev;
		}
		return -1;
	}
}
