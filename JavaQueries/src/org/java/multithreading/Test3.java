package org.java.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Test3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nq = br.readLine();
		String nq1[] = nq.trim().split(" "); 
		int n = Integer.parseInt(nq1[0]);
		int q = Integer.parseInt(nq1[1]);
		int A[] = new int[n];
		for(int i=0; i<n; i++) {
			A[i] = 0;
		}
		for(int j=0; j<q; j++) {
			String op = br.readLine();
			String[] opr = op.trim().split(" ");
			int opn[] = new int[opr.length];
			for(int i=0; i<opr.length; i++) {
				opn[i] = Integer.parseInt(opr[i]);
			}
			if(opn[0] == 1) {
				A = operation1(A, opn[1]);
			}
			if(opn[0] == 2) {
				A = operation2(A, opn[1]);
			}
			if(opn[0] == 3) {
				operation3(A, opn[1], opn[2]);
			}
		}
	}
	
	public static int[] operation1(int A[], int x) {
		A[x-1] = 2*A[x-1]+1;
		return A;
	}
	
	public static int[] operation2(int A[], int x) {
		A[x-1] = (int) Math.floor(A[x-1]);
		return A;
	}

	public static void operation3(int A[], int x, int y) {
		String bin = "";
		String binaryString = "";
		for(int i=(x-1); i<y; i++) {
			if(i>=(x-1) && i<=(y-1)) {
				binaryString = Integer.toBinaryString(A[i]);
				bin = bin + binaryString;
			}
		}
		bin = bin.replaceAll("0", "");
		System.out.println(bin.length());
	}
}
