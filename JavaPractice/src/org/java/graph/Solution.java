package org.java.graph;

import java.util.LinkedList;

public class Solution{

    int V;
    int adj[][];
    LinkedList<Integer> arr[];
    int parent[];
    
    Solution(int V) {
        this.V = V;
        this.adj = new int[V][V];
        this.arr = new LinkedList[V];
        this.parent = new int[V];
        for(int i=0; i<V; i++) {
        	//arr[i] = new LinkedList<>();
        	parent[i] = -1;
        }
    }
    
    public void addEdge(int u, int v, int w) {
        adj[u][v] = w;
    }
    
    public void Dijkstra(int s) {
        boolean visited[] = new boolean[V];
        int dist[] = new int[V];
        for(int i=0; i<V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        //visited[s] = true;
        dist[s] = 0;
        parent[s] = s;
        arr[s] = new LinkedList<>();
        
        for(int count=0; count<V; count++) {
            int u = minDistance(visited, dist);
            visited[u] = true;
            for(int v=0; v<V; v++) {
                if(!visited[v] && dist[u] != Integer.MAX_VALUE && adj[u][v] != 0 && dist[u]+adj[u][v] < dist[v]) {
                dist[v] = dist[u]+adj[u][v];
                parent[v] = u;
                //arr[u].add(u);
                }
            }
            arr[u] = new LinkedList<>(arr[parent[u]]);
            arr[u].add(u);
        }
        print(dist);
    }
    
    public int minDistance(boolean visited[], int dist[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for(int v=0; v<V; v++) {
            if(visited[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
    
    void print(int dist[]) {
        System.out.println("Vertext distance from source: ");
        for(int i=0; i<V; i++) {
            System.out.println(i +" - "+dist[i]+ " - "+arr[i]);
        }
    }

     public static void main(String []args){
        int V = 9;
        Solution graph = new Solution(V);
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
		graph.Dijkstra(0);
     }
}