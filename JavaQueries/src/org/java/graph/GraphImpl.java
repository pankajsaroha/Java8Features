package org.java.graph;

public class GraphImpl {

	public static void main(String args[]) {
		int V = 5;
		Graph graph = new Graph(V);
		
		addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        
        printGraph(graph);
	}
	
	static void addEdge(Graph graph, int src, int dest) {
		graph.adjListArray[src].addFirst(dest);
		graph.adjListArray[dest].addFirst(src);
	}
	
	static void printGraph(Graph graph) {
		for(int v=0; v<graph.V; v++) {
			System.out.println("Adjacency of list vertex "+v);
			System.out.print("head ");
			for(Integer pCrawl : graph.adjListArray[v]) {
				System.out.print(" -> "+pCrawl);
			}
			System.out.println();
		}
	}
}
