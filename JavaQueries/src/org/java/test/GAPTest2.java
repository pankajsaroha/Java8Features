package org.java.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class GAPTest2 {

	long n;
	LinkedList<Long> adj[];
	LinkedList<Long> traversed[];
	long A[] = new long[(int) n];
	
	GAPTest2(long n, long A[]) {
		this.n = n;
		this.A = A;
		adj = new LinkedList[(int) n];
		traversed = new LinkedList[(int) n];
		for(long i=0; i<n; i++) {
			adj[(int) i] = new LinkedList<>();
			traversed[(int) i] = new LinkedList<>();
		}
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long A[] = new long[(int) n];
		for(long i=0; i<n; i++) {
			A[(int) i] = in.nextLong();
		}
		GAPTest2 graph = new GAPTest2(n, A);
		
		for(long i=0; i<n-1; i++) {
			//System.out.prlongln("u, v");
			long u = in.nextLong();
			long v = in.nextLong();
			u--;
			v--;
			graph.addEdge(u, v);
		}
		long count = 0;
		for(long i=0; i<n; i++) {
			graph.printAllPaths(0, i, i);
			if(!graph.checkForDuplicates(graph.traversed[(int) i])) {
				count++;
			}
		}
		
		System.out.println(count);
		in.close();
	}
	
	void addEdge(long u, long v) {
		adj[(int) u].add(v);
	}
	
	public void printAllPaths(long s, long d, long vertex) 
    {
        boolean[] isVisited = new boolean[(int) n];
         
        traversed[(int) vertex].add(A[0]);
         
        printAllPathsUtil(s, d, isVisited, vertex);
    }
    private boolean printAllPathsUtil(long u, long d, boolean[] isVisited, long vertex) {
         
        isVisited[(int) u] = true;
         
        if (u == d) 
        {
        	return true;
        }
        for(long i : adj[(int) u]) {
        	if(i == d) {
        		traversed[(int) vertex].add(A[(int) i]);
        		return true;
        	}
        }
        for (long i : adj[(int) u]) 
        {
            if (!isVisited[(int) i])
            {
                traversed[(int) vertex].add(A[(int) i]);
                boolean res = printAllPathsUtil(i, d, isVisited, vertex);
                 if(res) {
                	 return true;
                 } else {
                	 traversed[(int) vertex].removeLast();
                 }
            }
        }
         
        isVisited[(int) u] = false;
        return false;
    }
    
    boolean checkForDuplicates(LinkedList<Long> list) {
    	Set<Long> set = new HashSet<>(list);
    	
    	if(set.size() < list.size()) {
    		return true;
    	}
    	
    	return false;
    }
}
