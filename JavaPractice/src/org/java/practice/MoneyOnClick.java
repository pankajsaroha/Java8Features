package org.java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoneyOnClick {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(", ");
		int arr[] = new int[input.length];
		for(int i=0; i<input.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		System.out.println(maxProduct(arr));
	}
	
	public static int maxProduct(int arr[]) {
		int output = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				int prod = 1;
				for(int k=i; k<=j; k++) {
					prod *= arr[k];
				}
				if(prod > output) {
					output = prod;
				}
			}
		}
		return output;
	}
}
