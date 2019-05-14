package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SprinklrTest1 {

	public static void main(String args[]) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			SprinklrTest1 s = new SprinklrTest1();
			int t = Integer.parseInt(br.readLine().trim());
			for (int j = 0; j < t; j++) {
				long x = Long.parseLong(br.readLine().trim());
				long sum = 0;
				int n = 1;
				if(x > 1000000000) {
				    n = 77347884;
				    sum = 1000000008;
				}
				while (sum < x) {
					sum += s.getBeauty(n);
					n++;
				}
				System.out.println(sum);
				System.out.println(--n);
			}
		} catch (Exception e) {

		}
	}

	int getBeauty(long number) {
		int beauty = 0;
		while (number > 0) {
			beauty += (number & 1);
			number = number / 2;
		}
		return beauty;
	}
}
