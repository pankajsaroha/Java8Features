package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class binarytree {

	static class Node {
        int key;
        Node left, right;
         
        // constructor
        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }
	
	static Node root = null;
    static Node temp = root;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("N, x :");
		String s = br.readLine();
		String[] nm = s.trim().split(" ");
		int n = Integer.parseInt(nm[0]);
		int x = Integer.parseInt(nm[1]);
		int nodes[] = new int[n];
		System.out.println("node values :");
		Scanner in = new Scanner(System.in);
		for(int i=0; i<n; i++) {
			nodes[i] = in.nextInt();
		}
		root = new Node(nodes[0]);
		for(int i=1; i<nodes.length; i++) {
			insert(root, nodes[i]);
		}
		
		inorder(root);
	}
		
	static void insert(Node temp, int key)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
      
        // Do level order traversal until we find
        // an empty place. 
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
      
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else
                q.add(temp.left);
      
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else
                q.add(temp.right);
        }
    }
	
	static void inorder(Node temp)
    {
        if (temp == null)
            return;
      
        inorder(temp.left);
        System.out.print(temp.key+" ");
        inorder(temp.right);
    }
}
