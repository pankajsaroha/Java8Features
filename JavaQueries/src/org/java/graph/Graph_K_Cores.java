package org.java.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph_K_Cores {

	int V;
	LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	Graph_K_Cores(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++)
			adj[i] = new LinkedList<>();
	}
	
	void addEdge(int v, int u) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	boolean DFSUtil(int v, boolean visited[], int[] vDegree, int k) {
		visited[v] = true;
		
		Iterator<Integer> itr = adj[v].iterator();
		while(itr.hasNext()) {
			int n = itr.next();
			
			if(vDegree[v] < k) {
				vDegree[n] = vDegree[n] - 1;
			}
			
			if(!visited[n]) {
				if(DFSUtil(n, visited, vDegree, k)) {
					vDegree[v] = vDegree[v] - 1;
				}
			}
		}
		
		return vDegree[v] < k;
	}
	
	void printKCores(int k) {
		boolean visited[] = new boolean[V];
		int vDegree[] = new int[V];
		
		for(int i=0; i<V; i++)
			vDegree[i] = adj[i].size();
		
		DFSUtil(0, visited, vDegree, k);
		
		for(int i=0; i<V; i++) {
			if(visited[i] == false) {
				DFSUtil(i ,visited, vDegree, k);
			}
		}
		
		System.out.println("K Cores: ");
		for (int v=0; v<V; v++) {
			if(vDegree[v] >= k) {
				System.out.print("["+v+"]");
				Iterator<Integer> itr = adj[v].iterator();
				while(itr.hasNext()) {
					int n = itr.next();
					if(vDegree[n] >= k) {
						System.out.print(" -> "+n);
					}
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String args[]) {
		int k = 3;
		Graph_K_Cores g1 = new Graph_K_Cores (9);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 5);
		g1.addEdge(2, 3);
		g1.addEdge(2, 4);
		g1.addEdge(2, 5);
		g1.addEdge(2, 6);
		g1.addEdge(3, 4);
		g1.addEdge(3, 6);
		g1.addEdge(3, 7);
		g1.addEdge(4, 6);
		g1.addEdge(4, 7);
		g1.addEdge(5, 6);
		g1.addEdge(5, 8);
		g1.addEdge(6, 7);
		g1.addEdge(6, 8);
		g1.printKCores(k);
		 
		Graph_K_Cores g2 = new Graph_K_Cores(13);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(0, 3);
		g2.addEdge(1, 4);
		g2.addEdge(1, 5);
		g2.addEdge(1, 6);
		g2.addEdge(2, 7);
		g2.addEdge(2, 8);
		g2.addEdge(2, 9);
		g2.addEdge(3, 10);
		g2.addEdge(3, 11);
		g2.addEdge(3, 12);
		g2.printKCores(k);
	}
}
