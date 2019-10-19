package org.java.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph_BFS {

	private int V;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public Graph_BFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i)
			adj[i] = new LinkedList<>();
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	//print BFS from a given source s
	public void BFS(int s) {
		
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0) {
			s = queue.poll();
			System.out.print(s+" ");
			
			Iterator<Integer> itr = adj[s].iterator();
			while(itr.hasNext()) {
				
				int n = itr.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	void DFS(int s) {
		boolean visited[] = new boolean[V];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		visited[s] = true;
		stack.push(s);
		
		while(!stack.isEmpty()) {
			s = stack.peek();
			stack.pop();
			System.out.print(s+" ");
			
			Iterator<Integer> itr = adj[s].iterator();
			while(itr.hasNext()) {
				int n = itr.next();
				if(!visited[n]) {
					visited[n] = true;
					stack.push(n);
				}
			}
		}
	}
	
	/*void DFS(int s) {
		boolean visited[] = new boolean[V];
		DFSUtil(s, visited);
	}
	
	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v+" ");
		
		Iterator<Integer> itr = adj[v].iterator();
		while(itr.hasNext()) {
			int n = itr.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}*/
	
	public static void main(String args[]) {
		Graph_BFS g = new Graph_BFS(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
        System.out.println();
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
	}
}
