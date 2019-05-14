package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.java.graph.Dijkstra;

public class AmericanExpress1{

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int adj[][] = new int[n][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a-1][b-1] = 1;
			adj[b-1][a-1] = 1;
		}
		int q = Integer.parseInt(br.readLine().trim());
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(adj[x-1][y-1] == 1) {
				System.out.println(1);
			} else {
				int count = 0;
				for(int j =0; j<adj[x-1].length; j++) {
					if(adj[x-1][j] == 1) {
						count++;
					}
				}
				System.out.println(count);
			}
		}
		Dijkstra d = new Dijkstra(n);
		d.dijkstra(adj, 0);
	}
}