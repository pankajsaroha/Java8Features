package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utopus1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int edges[][] = new int[n][n];
		Utopus1 ut = new Utopus1();
		for(int i=0; i<n-1; i++) {
			String uv[] = br.readLine().split(" ");
			int u = Integer.parseInt(uv[0]);
			int v = Integer.parseInt(uv[1]);
			ut.add(edges, u, v);
		}
		System.out.println(ut.findPrimeNodes(edges, n));
		br.close();
	}
	
	public void add(int edges[][], int u, int v) {
		edges[u-1][v-1] = v-1;
	}
	
	public int findPrimeNodes(int edges[][], int n) {
		int count = 0;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=0; j<n; j++) {
				if(edges[i][j] != 0)
					sum += edges[i][j]+1;
			}
			if(sum != 0 && isPrime(sum)) {
				count++;
			}
		}
		return count;
	}
	
	public boolean isPrime(int sum) {
		boolean flag = true;
		for(int i=2; i<=sum/2; i++) {
			if(sum%i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
