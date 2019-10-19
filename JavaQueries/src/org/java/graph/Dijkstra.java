package org.java.graph;

public class Dijkstra {

	int V;
	int adj[][];
	
	Dijkstra(int V) {
		this.V = V;
		adj = new int[V][V];
	}
	
	void addEdge(int u, int v, int w) {
		adj[u][v] = w;
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
	
	void dijkstra(int adj[][], int src) {
		int dist[] = new int[V];
		boolean sptSet[] = new boolean[V];
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for(int count=0; count<V-1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for(int v=0; v<V; v++) {
				if(!sptSet[v] && adj[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u]+adj[u][v] < dist[v]) {
					dist[v] = dist[u] + adj[u][v];
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
	
	public static void main(String args[]) {
		int V = 9;
		Dijkstra graph = new Dijkstra(V);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 0, 4);
		graph.addEdge(1, 7, 11);
		graph.addEdge(1, 2, 8);
		graph.addEdge(2, 1, 8);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 5, 4);
		graph.addEdge(2, 8, 2);
		graph.addEdge(3, 2, 7);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 3, 9);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 2, 4);
		graph.addEdge(5, 3, 14);
		graph.addEdge(5, 4, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 5, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 0, 8);
		graph.addEdge(7, 1, 11);
		graph.addEdge(7, 6, 1);
		graph.addEdge(7, 8, 7);
		graph.addEdge(8, 2, 2);
		graph.addEdge(8, 6, 6);
		graph.addEdge(8, 7, 7);
		/*for(int i=0; i<V; i++) {
			for(int j=0; j<V; j++) {
				System.out.print(graph.adj[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------");*/
		graph.dijkstra(graph.adj, 0);
	}
}
