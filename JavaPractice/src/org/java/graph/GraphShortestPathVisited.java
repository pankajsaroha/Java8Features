package org.java.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphShortestPathVisited {

	int V;
	List<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public GraphShortestPathVisited(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public static void main(String args[]) {
		int V = 9;
		GraphShortestPathVisited graph = new GraphShortestPathVisited(V);
		
		/*graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 5);
		graph.addEdge(4, 1);
		graph.addEdge(4, 5);
		graph.addEdge(4, 3);
		graph.addEdge(6, 4);
		graph.addEdge(5, 6);
		graph.addEdge(5, 3);
		graph.addEdge(3, 2);
		graph.addEdge(6, 0);*/
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 6);
		graph.addEdge(4, 5);
		graph.addEdge(5, 7);
		graph.addEdge(7, 2);
		graph.addEdge(6, 8);
		graph.addEdge(8, 2);
	     
	     //graph.printAllVisitedPath(0, 2);
		graph.printShortestDistance(0, 2);
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	/*public void printAllVisitedPath(int s, int d) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> pathList = new LinkedList<Integer>();
		printAllVisitedPathUtil(s, d, visited, pathList);
	}
	
	boolean printAllVisitedPathUtil(int s, int d, boolean visited[], LinkedList<Integer> localPathList) {
		visited[s] = true;
		localPathList.add(s);
		if(s == d) {
			System.out.println(localPathList);
			return true;
		}
		
		for(Integer i : adj[s]) {
			if(d == i) {
				localPathList.add(i);
				System.out.println(localPathList);
				return true;
			}
			if(adj[i].contains(d)) {
				localPathList.add(i);
				localPathList.add(d);
				System.out.println(localPathList);
				return true;
			}
		}
		
		for(Integer i : adj[s]) {
			if(!visited[i]) {
				boolean res = printAllVisitedPathUtil(i, d, visited, localPathList);
				if(res)
					return true;
				else 
					localPathList.removeLast();
			}
			
		}
		return false;
	}*/
	
	boolean BFS(int s, int d, int pred[], int dist[]) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[V];
		
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}
		
		visited[s] = true;
		dist[s] = 0;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			for(Integer i : adj[u]) {
				if(visited[i] == false) {
					visited[i] = true;
					dist[i] = dist[u] + 1;
					pred[i] = u;
					queue.add(i);
					
					if(i.equals(d)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	void printShortestDistance(int s, int d) {
		int pred[] = new int[V];
		int dist[] = new int[V];
		
		if(BFS(s, d, pred, dist) == false) {
			System.out.println("Source and destination not connected");
			return;
		}
		
		LinkedList<Integer> path = new LinkedList<Integer>();
		int crawl = d;
		path.add(crawl);
		while(pred[crawl] != -1) {
			path.addFirst(pred[crawl]);
			crawl = pred[crawl];
		}
		
		System.out.println("Path length : "+dist[d]);
		
		System.out.println("Path : ");
		for(Integer i: path) {
			System.out.print(i+" ");
		}
	}
}
