package org.java.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph_Set {

	int V;
	Set<Integer> adjList[];
	
	@SuppressWarnings("unchecked")
	Graph_Set(int V) {
		this.V = V;
		adjList = new Set[V];
		for(int i=0; i<V; i++)
			adjList[i] = new HashSet<>();
	}
	
	public static void main(String args[]) {
		int V = 5;
	    Graph_Set graph = new Graph_Set(V);
	    addEdge(graph, 0, 1);
	    addEdge(graph, 0, 4);
	    addEdge(graph, 1, 2);
	    addEdge(graph, 1, 3);
	    addEdge(graph, 1, 4);
	    addEdge(graph, 2, 3);
	    addEdge(graph, 3, 4);
	 
	    // Print the adjacency list representation of
	    // the above graph
	    printGraph(graph);
	    
	    searchEdge(graph, 2, 1);
	    searchEdge(graph, 0, 3);
	}
	
	static void addEdge(Graph_Set graph, int u, int v) {
		graph.adjList[u].add(v);
		graph.adjList[v].add(u);
	}
	
	static void printGraph(Graph_Set graph) {
		for (int i=0; i<graph.V; i++) {
			System.out.println("Adjacency matrix of vertex "+i);
			System.out.print("head ");
			for(Integer pCrawl : graph.adjList[i]) {
				System.out.print(" -> "+pCrawl);
			}
			System.out.println();
		}
	}
	
	static void searchEdge(Graph_Set graph, int src, int dest) {
		boolean flag = false;
		Iterator<Integer> itr = graph.adjList[src].iterator();
		while(itr.hasNext()) {
			if(itr.next() == dest) {
				flag = true;
				System.out.println("Found");
				break;
			}
		}
		if(!flag) {
			System.out.println("Not found");
		}
	}
}