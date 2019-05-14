package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Meesho2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Meesho2 m = new Meesho2();
		int test = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < test; t++) {
			int n = Integer.parseInt(br.readLine().trim());
			int d[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					d[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(m.checkMatrix(d, n));
		}
	}

	public String checkMatrix(int d[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					if (d[i][j] != 0)
						return "NO";
				} else {
					if (d[i][j] > dijkstra(d, i, j, n)) {
						return "NO";
					}
				}
			}
		}
		return "YES";
	}

	public int dijkstra(int d[][], int src, int des, int n) {
		int dist[] = new int[n];
		boolean sptSet[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for (int count = 0; count < n; count++) {
			int u = minDistance(dist, sptSet, n);
			sptSet[u] = true;
			if (u == des) {
				return dist[u];
			}
			for (int v = 0; v < n; v++) {
				if (!sptSet[v] && d[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + d[u][v] < dist[v]) {
					dist[v] = dist[u] + d[u][v];
				}
			}
		}
		return -1;
	}

	int minDistance(int dist[], boolean sptSet[], int n) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < n; v++) {
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}

}
