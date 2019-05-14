package org.java.test;

import java.util.Scanner;

public class Lenskart2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int t=0; t<testCases; t++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();
			int m = in.nextInt();
			int n = in.nextInt();
			long arr[] = new long[n];
			for(int i=0; i<n; i++) {
				arr[i] = in.nextLong();
			}
			int p = 1000000007;
			int count = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					long x = arr[i]%p;
					long y = arr[j]%p;
					long lhs = (y)*(y) % m;
					long rhs = ((a*(x)*(x)*(x)) + (b*(x)*(x)) + (c*(x)) + d) % m;
					if(lhs == rhs ) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
		in.close();
	}

}
