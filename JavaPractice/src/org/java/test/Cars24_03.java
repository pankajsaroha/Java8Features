package org.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Cars24_03 {

	class Node {
		Node left, right;
	}
	static List<Integer> leaf = new ArrayList<>();
	public static void main(String args[]) {
		try {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n :");
		int n = in.nextInt();
		List<Integer> tree = new ArrayList<>();
		for(int i=0; i<n-1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			addEdge(tree, a, b);
		}
		System.out.println("Height : "+maxDepth(tree, tree.get(0)));
		System.out.println(leaf.get(0)+" "+leaf.get(leaf.size()-1));
		}catch(Exception e ) {
			return;
		}
	}
	
	static void addEdge(List<Integer> tree, int a, int b) {
		if(!tree.contains(a)) {
			tree.add(a);
		}
		
			int index = tree.indexOf(a);
			index = 2*index + 1;
			try {
			if(tree.get(index) != null) {
				tree.add(index+1, b);
			}
		}catch(IndexOutOfBoundsException e) {
				tree.add(index, b);
			}
	}
	
	static int maxDepth(List tree, Integer node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
        	int lDepth, rDepth;
            /* compute the depth of each subtree */
        	int index = tree.indexOf(node);
        	try {
        		lDepth = maxDepth(tree, (Integer) tree.get(2*index+1));
        	}catch(IndexOutOfBoundsException e) {
        		leaf.add((Integer) tree.get(index));
        		return 0;
        	}
        	try {
        		rDepth = maxDepth(tree, (Integer) tree.get(2*index+2));
        	}catch(IndexOutOfBoundsException e) {
        		leaf.add((Integer) tree.get(index));
        		return 0;
        	} 
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    } 
}
