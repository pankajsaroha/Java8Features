package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AmericanExpress2 {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < test; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int a[] = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			//subArray(a);
			System.out.println(Math.abs(subArray(a) - p));
		}
	}

	public static int findSubArrays(int arr[], int n) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int m = arr[i];
				for (int k = i + 1; k <= j; k++) {
					m = m & arr[k];
				}
				if (min > m) {
					min = m;
				}
			}
		}
		return min;
	}

	public static int subArray(int a[]) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {

			//String s = "";
			int m = a[i];
			if(min > m) {
				min = m;
			}
			for (int j = i+1; j < a.length; j++) {

				//s = s + a[j] + " ";
				m = m&a[j];
				if(min > m) {
					min = m;
				}

			}

		}
		return min;
	}

}
