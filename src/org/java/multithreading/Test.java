package org.java.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Test {

	public static void main(String args[]) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Elements size:");
		//int n = in.nextInt();
		int n = Integer.parseInt(br.readLine());
		System.out.println("Array :");
		int A[] = new int[n];
		String arr = br.readLine();
		String array[] = arr.trim().split(" ");
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(array[i]);
		}
		int sum = maxSum(A, n);
		System.out.println("Max : "+sum);
		while(sum > 1) {
			if(sum%2 == 0) {
				sum = sum/2;
			}else {
				break;
			}
		}
		if(sum == 1) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
	public static int maxSum(int A[], int n) {
		int sum = 0;
		int sum2 = 0;
		for(int i=0; i<n; i++) {
			if(A[i] < 0) {
				if(sum2 ==0) {
					sum2 = A[i];
				}else {
					if(sum2<A[i] ) {
						sum2 = A[i];
					}
				}
			}else {
				sum = sum+A[i];
			}
		}
		if(sum != 0)
			return sum;
		else
			return sum2;
	}
}
