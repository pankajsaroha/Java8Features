package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Pramata1 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         int m = Integer.parseInt(br.readLine().trim());
         char[][] A = new char[n][m];
         for(int i_A=0; i_A<n; i_A++)
         {
         	String[] arr_A = br.readLine().split(" ");
         	for(int j_A=0; j_A<arr_A.length; j_A++)
         	{
         		A[i_A][j_A] = arr_A[j_A].charAt(0);
         	}
         }

         String out_ =""; solve(A, "", n, m );
         System.out.println(out_);

         wr.close();
         br.close();
    }

	static class Node {
		char data;
		Node left;
		Node right;
		
		public Node(char data) {
			this.data = data;
		}
	}
	
	static void solve(char[][] a, String output, int n, int m){
		int i=0;
		int j=0;
		Node root = new Node(a[0][0]);
		LinkedList<Character> parent = new LinkedList<>();
		parent.add(a[0][0]);
		int count = 0;
		while(!parent.isEmpty()) {
			char baap = parent.poll();
			if(j+1 < m && i < n) {
				root = insert(root, baap, a[i][j+1]);
				parent.add(a[i][j+1]);
			}
			if(i+1 < n && j < m) {
				root = insert(root, baap, a[i+1][j]);
				parent.add(a[i+1][j]);
			}
			j++;
			if(++count % 2 == 0) {
				i++;
				j=j-2;
			}
		}
		
    }
	
	static Node insert(Node root, char parent, char c) {
		Node temp = root;
		Node node = new Node(c);
		if(temp == null) {
			return root;
		} else {
			
			LinkedList<Node> queue = new LinkedList<>();
			queue.add(temp);
			
			while(!queue.isEmpty()) {
				Node n = queue.poll();
				if(n.data == parent) {
					if (n.left == null) {
						n.left = node;
					} else if (temp.right == null) {
						n.right = node;
					}
					return root;
				} else {
					if(n.left != null) {
						queue.add(n.left);
					}
					if(n.right != null) {
						queue.add(n.right);
					}
				}
			}
			
		}
		return root;
	}
}
