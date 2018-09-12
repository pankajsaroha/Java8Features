package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GAPTest1 {

	public static void main(String args[]) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		System.out.println("N M F");
		/*String nmf = br.readLine();
		String nmf1[] = nmf.trim().split(" ");
		int n = Integer.parseInt(nmf1[0]);
		int m = Integer.parseInt(nmf1[1]);
		int f = Integer.parseInt(nmf1[2]);*/
		int n = in.nextInt();
		int m = in.nextInt();
		int f = in.nextInt();
		
		int C[] = new int[n];
		
		for(int i=0; i<n; i++) {
			C[i] = in.nextInt();
		}
		
		
	}
}
