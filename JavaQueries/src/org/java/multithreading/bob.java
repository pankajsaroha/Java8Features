package org.java.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bob {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("N , M :");
		String nm_1 = br.readLine();
		String nm[] = nm_1.trim().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		char city[][] = new char[n][m];
		System.out.println("Input :");
		for(int i=0; i<n; i++) {
			//System.out.println("Row : ");
			String row1 = br.readLine();
			String[] row = row1.trim().split("");
			for(int j=0; j<row.length; j++) {
				city[i][j] = row[j].charAt(0);
			}
		}
		
		System.out.println("No of operations :");
		int q = Integer.parseInt(br.readLine());
		
		for(int i=0; i<q; i++) {
			System.out.println("length of square :");
			int k = Integer.parseInt(br.readLine());
			System.out.println(getSum(city, k, n, m));
		}
		//System.out.println(getSum(city, 3, n, m));
		//System.out.println(getSum(city, 2, n, m));
	}
	
	static int getSum(char[][] city, int len, int n, int m) {
		int sum = 0;
		for(int i=len; i>1; i--) {
			sum =sum+getMat(city, i, n, m);
		}
		return sum+getSumLength1(city, n, m);		
	}
	
	static int getMat(char[][] city, int len, int n, int m) {
		int count = 0;
		char city_sub[][] = new char[len][len];
		for(int i=0; i<n-len+1; i++) {
			for(int j=0; j<m-len+1; j++) {
				for(int k=i; k<len+i; k++) {
					for(int l=j; l<len+j; l++) {
						city_sub[k-i][l-j] = city[k][l];
						//System.out.print(city_sub[k-i][l-j]);
					}
					//System.out.println();
				}
				if(checkForSame(city_sub, len, len))
					count++;
			}
		}
		//System.out.println("Count :"+count);
		return count;
	}
	
	static int getSumLength1(char[][] city, int n, int m) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(city[i][j] == '*') 
					sum = sum+1;
			}
		}
		return sum;
	}

	static boolean checkForSame(char[][] city_sub, int n, int m) {
		char first = city_sub[0][0];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(city_sub[i][j] != first)
					return false;
			}
		}
		return true;
	}
}
