package org.java.houseofbots;

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReverse {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		for(int i=0, j=n-1; i<=j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
		in.close();
	}
}
