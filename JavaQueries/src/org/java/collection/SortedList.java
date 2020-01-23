package org.java.collection;

import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

class SortedList<T> {

	class Node {
		T data;
		Node left;
		Node right;

		Node(T data) {
			this.data = data;
		}
	}

	Node root;

	public void add(T data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp.left == null) {
				temp.left = new Node(data);
				return;
			}
			queue.add(temp.left);
			if (temp.right == null) {
				temp.right = new Node(data);
				return;
			}
			queue.add(temp.right);
		}
	}

	public void inOrder(Node temp) {
		if (temp != null) {
			inOrder(temp.left);
			System.out.print(temp.data + " ");
			inOrder(temp.right);
		}
	}

	public void inOrderRecursive() {
		Node current = root;
		Deque<Node> stack = new ArrayDeque<>();
		//stack.add(current);

		while (current != null || stack.size() > 0) {

			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();

			System.out.print(current.data + " ");

			current = current.right;
		}
	}

	public boolean isIdentical(Node tree1, Node tree2) {
		if (tree1 == tree2 && tree1 == null) {
			return true;
		}
		if (tree1 != null && tree2 != null) {
			if (tree1.data == tree2.data) {
				if (isIdentical(tree1.left, tree2.left) && isIdentical(tree1.right, tree2.right)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		SortedList<Integer> b = new SortedList<>();
		SortedList<Integer> b1 = new SortedList<>();
	    int arr[] = {5, 3, 6, 7, 2, 1, 9};
	    for(Integer i : arr) {
	      b.add(i);
	      b1.add(i);
	    }
	    //b1.add(4);
	    
	    b.inOrder(b.root);
	    System.out.println();
	    //System.out.println("Identical : " + b.isIdentical(b.root, b1.root));
	    b1.inOrderRecursive();
	}
}