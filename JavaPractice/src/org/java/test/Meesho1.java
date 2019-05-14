package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Meesho1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		long arr[] = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long prod = 1;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prod *= arr[i];
		}
		Meesho1 m = new Meesho1();
		System.out.println(m.find(prod, n, arr));
	}

	/*public int find(long arr[]) {
		int n = arr.length;
		int x = -1;
		long min = Long.MAX_VALUE;
		for(int i=0; i<n; i++) {
			long prod1 = 1;
			long prod2 = 1;
			for(int j=0; j<=i; j++) {
				prod1 *= arr[j];
			}
			for(int k=i+1; k<n; k++) {
				prod2 *= arr[k];
			}
			if(Math.abs(prod1-prod2) <= min) {
				min = Math.abs(prod1 - prod2);
				x = i;
			}
		}
		return x;
	}*/
	
	public int find(long prod, int n, long arr[]) {
		long p = 1;
		long min = Long.MAX_VALUE;
		int x = -1;
		for(int i=0; i<n; i++) {
			p *= arr[i];
			long second = prod/p;
			if(Math.abs(p - second) <= min) {
				min = Math.abs(p - second);
				x = i;
			}
		}
		return x;
	}
}
