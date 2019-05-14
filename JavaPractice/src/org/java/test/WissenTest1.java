package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WissenTest1 {
	
	static class Node {
		int data;
		Node left;
		Node right;
		int parent;
		Node(int data, int parent) {
			this.data = data;
			this.parent = parent;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WissenTest1 test = new WissenTest1();
		Node root = null;
		int n = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			root = test.makeTree(root, i, Integer.parseInt(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine().trim());
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			count += test.deleteNode(root, Integer.parseInt(st.nextToken()));
		}
		System.out.println(count);
	}
	
	public Node makeTree(Node root, int data, int parent) {
		Node node = new Node(data, parent);
		if(root == null || parent == -1) {
			return node;
		} else {
			Node temp = searchParent(root, parent);
			if(temp.left == null) {
				temp.left = node;
			} else if(temp.right == null) {
				temp.right = node;
			}
		}
		return root;
	}
	
	public Node searchParent(Node root, int parent) {
		Node current = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		if(parent == root.data)
			return root;
		else {
			while(!queue.isEmpty()) {
				current = queue.peek();
				queue.remove();
				if(parent == current.data) {
					return current;
				}else {
					if(current.left != null) {
						queue.add(current.left);
					}
					if(current.right != null) {
						queue.add(current.right);
					}
				}
			}
		}
		return root;
	}
	
	public Node searchElement(Node root, int data) {
		Node current = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		if(data == root.data)
			return root;
		else {
			while(!queue.isEmpty()) {
				current = queue.peek();
				queue.remove();
				if(data == current.data) {
					return current;
				}else {
					if(current.left != null) {
						queue.add(current.left);
					}
					if(current.right != null) {
						queue.add(current.right);
					}
				}
			}
		}
		return null;
	}
	
	public int deleteNode(Node root, int data) {
		Node temp = searchElement(root, data);
		if(temp != null) {
			Node par = searchParent(root, temp.parent);
			if(par.left == temp) {
				par.left = null;
			} else if(par.right == temp) {
				par.right = null;
			}
			
				temp = null;
				return 1;

		}
		return 0;
		
	}
}
