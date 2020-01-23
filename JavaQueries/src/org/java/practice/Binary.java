package org.java.practice;

public class Binary {

	public static void main(String[] args) {
		Binary t = new Binary();
	    System.out.println(t.binary(new int[] {1, 2 , 6, 7, 9}, 0));
	}

	boolean binary(int arr[], int key) {
		int low = 0;
		int high = arr.length - 1;

		int i = 0;

		do {
			i = (low + high) / 2;
			if (key < arr[i]) {
				high = i - 1;
			} else {
				low = i + 1;
			}
		} while ((low <= high) && !(key == arr[i]));

		if (key == arr[i]) {
			return true;
		} else {
			return false;
		}
	}
}
