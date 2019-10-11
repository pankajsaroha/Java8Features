package org.java.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("N , M :");
		String nm_1 = br.readLine();
		String nm[] = nm_1.trim().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		char city[][] = new char[n][m];
		for(int i=0; i<n; i++) {
			System.out.println("Row : ");
			String row1 = br.readLine();
			String[] row = row1.trim().split(" ");
			for(int j=0; j<row.length; j++) {
				city[i][j] = row[j].charAt(0);
			}
		}
		
		System.out.println("cost : ");
		String cost1 = br.readLine();
		String cost[] = cost1.trim().split(" ");
		int LCost = Integer.parseInt(cost[0]);
		int RCost = Integer.parseInt(cost[1]);
		int UCost = Integer.parseInt(cost[2]);
		int DCost = Integer.parseInt(cost[3]);
		
		System.out.println("address : ");
		String address = br.readLine();
		String adr[] = address.trim().split(" ");
		int stx = Integer.parseInt(adr[0]) - 1;
		int sty = Integer.parseInt(adr[1]) - 1;
		
		System.out.println("q : ");
		int visited = 0;
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			System.out.println("Amount :");
			int amount = Integer.parseInt(br.readLine());
			int j = stx;
			int k = sty;
			while(amount >= 0) {
				
					if(city[j][k] == '.' && city[j][k++] == '.') {
						amount = amount-RCost;
					}
				}
			}
		}
}
