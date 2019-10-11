package org.java.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph_Mother_Vertex {

	int V;
	LinkedList<Integer> adj[];
	
	Graph_Mother_Vertex(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++)
			adj[i] = new LinkedList<>();
	}
	
	void addEdge(Graph_Mother_Vertex graph, int v, int w) {
		graph.adj[v].add(w);
	}
	
	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		//System.out.print(v+" ");
		Iterator<Integer> itr = adj[v].iterator();
		while(itr.hasNext()) {
			int n = itr.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	
	int findMother() {
		boolean visited[] = new boolean[V];
		int v = 0;
		for(int i=0; i<V; i++) {
			if(!visited[i]) {
				DFSUtil(i, visited);
				v = i;
			}
		}
		
		for(int i=0; i<V; i++)
			visited[i] = false;
		
		DFSUtil(v, visited);
		for(int i=0; i<V; i++) {
			if(!visited[i])
				return -1;
		}
		
		return v;
	}
	
	public static void main(String args[]) {
		int V = 7;
		Graph_Mother_Vertex graph = new Graph_Mother_Vertex(V);
		graph.addEdge(graph, 0, 1);
		graph.addEdge(graph, 0, 2);
		graph.addEdge(graph, 1, 3);
		graph.addEdge(graph, 4, 1);
		graph.addEdge(graph, 6, 4);
		graph.addEdge(graph, 5, 6);
		graph.addEdge(graph, 5, 2);
		graph.addEdge(graph, 6, 0);
		
		boolean visited[] = new boolean[V];
		//graph.DFSUtil(5, visited);
		System.out.println("A mtoher vertex is "+graph.findMother());
	}
}
