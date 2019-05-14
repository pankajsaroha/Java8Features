package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Utopus2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		long city[] = new long[n];
		String cty[] = br.readLine().split(" ");
		long sum = 0;
		long max = Long.MIN_VALUE;
		for(int i=0; i<n; i++) {
			city[i] = Integer.parseInt(cty[i]);
			sum = sum+city[i];
			if(city[i] > max) {
				max = city[i];
			}
		}
		System.out.println(sum-max);
		br.close();
	}

}
