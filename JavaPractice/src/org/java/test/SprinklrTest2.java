package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SprinklrTest2 {

	int V;
	int adj[][];
	List<List<Integer>> list = new ArrayList<>();
	
	SprinklrTest2(int V) {
		this.V = V;
		adj = new int[V][V];
	}
	
	void addEdge(int u, int v, int w) {
		adj[u][v] = w;
		adj[v][u] = w;
	}
	
	int minDistance(int dist[], boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for(int v=0; v<V; v++) {
			if(sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}
	
	void sprnklr(int adj[][], int src, int k) {
		int dist[] = new int[V];
		boolean sptSet[] = new boolean[V];
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;

		List<Integer> finalPath;
		List<Integer> lastList;
		int sum = 0;
		for(int count=0; count<V-1; count++) {
			if(!list.isEmpty()) {
				lastList = list.get(list.size()-1);
				for(Integer i : lastList) {
					sum += i;
				}
				finalPath = new ArrayList<>(lastList);
			} else {
				finalPath = new ArrayList<>();
			}
			
			int u = minDistance(dist, sptSet);
			
			if(!list.isEmpty()) {
				finalPath.add(dist[u] - sum);
			} else {
				finalPath.add(dist[u]);
			}			
			sptSet[u] = true;
			for(int v=0; v<V; v++) {
				if(!sptSet[v] && adj[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u]+adj[u][v] < dist[v]) {
					dist[v] = dist[u] + adj[u][v];
				}
			}
			list.add(finalPath);
		}
		sum = 0;
		if(!list.isEmpty()) {
			lastList = list.get(list.size()-1);
			for(Integer i : lastList) {
				sum += i;
			}
			finalPath = new ArrayList<>(lastList);
		} else {
			finalPath = new ArrayList<>();
		}
		
		int u = minDistance(dist, sptSet);
		
		if(!list.isEmpty()) {
			finalPath.add(dist[u] - sum);
		} else {
			finalPath.add(dist[u]);
		}
		
		list.add(finalPath);
		for(int i=0; i<list.size(); i++) {
			List<Integer> l = list.get(i);
			for(int j=0; j<k; j++) {
				if(!l.isEmpty()) {
					int last = l.get(l.size()-1);
					dist[i] -= last;
				}
			}
		}
		printSolution(dist);
	}
	
	void printSolution(int dist[]) {
		System.out.println("Vertex distance from source :");
		for(int i=0; i<V; i++) {
			System.out.println(i +" "+dist[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nmk[] = br.readLine().split(" ");
		int n = Integer.parseInt(nmk[0]);
		int m = Integer.parseInt(nmk[1]);
		int k = Integer.parseInt(nmk[2]);
		SprinklrTest2 graph = new SprinklrTest2(n);
		for(int i=0; i<m; i++) {
			String uvw[] = br.readLine().split(" ");
			int u = Integer.parseInt(uvw[0]);
			int v = Integer.parseInt(uvw[1]);
			int w = Integer.parseInt(uvw[2]);
			graph.addEdge(u-1, v-1, w);
		}
		
		graph.sprnklr(graph.adj, 0, k);
	}

}
