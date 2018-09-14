package org.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Graph_Transitive_Closure {

	int V;
	ArrayList<Integer> adj[];
	int tc[][];
	
	public Graph_Transitive_Closure(int V) {
		this.V = V;
		adj = new ArrayList[V];
		for(int i=0; i<V; i++) {
			adj[i] = new ArrayList<>();
		}
		this.tc = new int[V][V];
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		
	}
	
	public void  DFSUtil(int s, int v) {
		tc[s][v] = 1;
		Iterator<Integer> itr = adj[v].iterator();
		while(itr.hasNext()) {
			int n = itr.next();
			if(tc[s][n] == 0) {
				DFSUtil(s, n);
			}
		}
	}
	
	public void transitiveClosure() {
		for(int i=0; i<V; i++) {
			DFSUtil(i, i);
		}
		
		for(int i=0; i<V; i++) {
			System.out.println(Arrays.toString(tc[i]));
		}
	}
	
	public static void main(String args[]) {
		int V = 4;
		Graph_Transitive_Closure graph = new Graph_Transitive_Closure(V);
		graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("Transitive closure " +
                "matrix is");
 
        graph.transitiveClosure();
	}
}
