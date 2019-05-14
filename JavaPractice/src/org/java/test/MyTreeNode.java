package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class MyTreeNode{
	

	
	static class Node {
		int data;
		int parent;
		List<Node> children = new ArrayList<>();
		Node(int data, int parent) {
			this.data = data;
			this.parent = parent;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MyTreeNode test = new MyTreeNode();
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
			temp.children.add(node);
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
					for(Node no : current.children) {
						queue.add(no);
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
					for(Node no : current.children) {
						queue.add(no);
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
			if(par.children.contains(temp)) {
				par.children.remove(temp);
			}
			
				temp = null;
				return 1;

		}
		return 0;
		
	}

	
}