package org.java.houseofbots;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EqualSumPairs {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		int number = in.nextInt();
		EqualSumPairs e = new EqualSumPairs();
		e.equalSumPairs(arr, number);
		in.close();
	}
	
	public void equalSumPairs(int arr[], int number) {
		int n = arr.length;
		List<String> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i] + arr[j] == number) {
					if(!list.contains("("+arr[i]+", "+arr[j]+")") && !list.contains("("+arr[j]+", "+arr[i]+")")) {
						list.add("("+arr[i]+", "+arr[j]+")");
						System.out.println("("+arr[i]+", "+arr[j]+")");
					}
				}
			}
		}
	}
}
