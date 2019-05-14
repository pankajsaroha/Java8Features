package org.java.houseofbots;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class Stack {
		Deque<Node> stack = new ArrayDeque<>();
		
		public void push(Node node) {
			stack.push(node);
		}
		
		public Node pop() {
			return stack.poll();
		}
		
		public boolean isEmpty() {
			return stack.isEmpty();
		}
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		Node root = null;
		BinaryTree bt = new BinaryTree();
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			root = bt.insertBST(root, arr[i]);
		}
		bt.printTreeInOrder(root);
		System.out.println();
		bt.printPreOrderWithoutRecursion(root);
		in.close();
	}
	
	public Node insertBST(Node root, int data) {
		Node node = new Node(data);
		Node temp = root;
		if(temp == null) {
			return node;
			
		} else {
			if(temp.data > data) {
				if(temp.left == null) {
					temp.left = node;
				} else {
					insertBST(temp.left, data);
				}
			}
			if(temp.data < data) {
				if(temp.right == null) {
					temp.right = node;
				} else {
					insertBST(temp.right, data);
				}
			}
		}
		return root;
	}
	
	public void printTreeInOrder(Node root) {
		Node temp = root;
		if(temp != null) {
			printTreeInOrder(temp.left);
			System.out.print(temp.data+" ");
			printTreeInOrder(temp.right);
		}
	}
	
	public void printPreOrderWithoutRecursion(Node root) {
		Stack stack = new Stack();
		stack.push(root);
		
		while(! stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.data+" ");
			
			if(temp.right != null) {
				stack.push(temp.right);
			}
			
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
}
