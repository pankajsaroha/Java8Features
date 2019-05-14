package org.java.houseofbots;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class MissingNumber {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n-1];
		for(int i=0; i<n-1; i++) {
			arr[i] = in.nextInt();
		}
		MissingNumber m = new MissingNumber();
		System.out.println(m.missingNumberByMaths(arr, n));
		System.out.println(m.missingNumberByBitSet(arr, n));
		in.close();
	}
	
	public int missingNumberByMaths(int arr[], int n) {
		return ((n*(n+1))/2) - Arrays.stream(arr).sum();
	}
	
	public int missingNumberByBitSet(int arr[], int n) {
		BitSet bitSet = new BitSet(n);
		for(int i=0; i<n-1; i++) {
			bitSet.set(arr[i]);
		}
		return bitSet.nextClearBit(1);
	}
}
