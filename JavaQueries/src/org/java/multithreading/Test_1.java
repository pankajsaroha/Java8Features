package org.java.multithreading;

import java.util.Scanner;
public class Test_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Test Cases : ");
		int t = in.nextInt();
		for(int test=0; test<t; test++) {
			System.out.println("No of elements : ");
			int n = in.nextInt();
			int arr[] = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = in.nextInt();
			}
			
			int result = equalArray(arr);
			System.out.println(result);
		}
		in.close();
	}
	
	static int equalArray(int arr[]) {
		int min = Integer.MAX_VALUE;
		int j = 0;
		int result = 0;
		
		while(j != arr.length-1) {
			int last_sum = 0;
			for(int k=j+1; k<arr.length; k++) {
				last_sum += arr[k];
			}
			int first_sum = 0;
			for(int k=0; k<=j; k++) {
				first_sum += arr[k];
			}
			result = last_sum - first_sum;
			if(min > result && result >= 0) {
				min = result;
			}
			j++;
		}
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		return min;
	}

}
