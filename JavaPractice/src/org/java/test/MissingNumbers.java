package org.java.test;

import java.util.BitSet;

public class MissingNumbers {

	public static void main(String args[]) {
		printMissingNumber(new int[] {1, 3, 4, 6, 7, 8, 9}, 10);
	}
	
	static void printMissingNumber(int arr[], int count) {
		BitSet bitSet = new BitSet(count);
		int missingCount = count-arr.length;
		for(int number : arr) {
			bitSet.set(number-1);
		}
		
		int lastMissingIndex  = 0;
		for(int i=0; i<missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}
	}
}
