package org.java.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EspilonTest1 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("No of test cases - ");
		int t = in.nextInt();
		for(int test=0; test<t; test++) {
			System.out.println("No of children ");
			int n = in.nextInt();
			int plate[] = new int[n];
			List<int[]> plt = Arrays.asList(plate);
			//Integer arr[] = (Integer[]) plt.toArray();
			System.out.println("Number plate array");
			for(int i=0; i<n; i++) {
				plate[i] = in.nextInt();
			}
			System.out.println("No of turns in game ");
			int q = in.nextInt();
			for(int i=0; i<q; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				long startTime = System.currentTimeMillis();
				if(a == 1) {
					//shiftLeft(plate, b);
					Collections.rotate(plt, b);
					//arr = (Integer[]) plt.toArray();
				}
				if(a == 2) {
					//shiftRight(plate, b);
					Collections.rotate(plt, -b);
					//arr = (Integer[]) plt.toArray();
				}
				if(a == 3) {
					System.out.println(plt.get(0)[b]);
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Execution time: "+ (endTime - startTime));
			}
		}
	}
	
	static void shiftLeft (int arr[], int b) {
		for(int i=0; i<b; i++) {
			shiftLeftByOne(arr, b);
		}
		
	}
	
	static int[] shiftLeftByOne(int arr[], int b) {
		int n = arr.length;
		int temp = arr[0];
		System.arraycopy(arr, 1, arr, 0, arr.length-1 );
		arr[n-1] = temp;
		return arr;
	}
	
	static void shiftRight(int arr[], int b) {
		for(int i=0; i<b; i++) {
			shiftRightByOne(arr, b);
		}
	}
	
	static int[] shiftRightByOne(int arr[], int b) {
		int n = arr.length;
		int temp = arr[n-1];
		System.arraycopy(arr, 0, arr, 1, arr.length-1 );
		arr[0] = temp;
		return arr;
	}
}
