package org.java.practice;

import java.util.LinkedList;
import java.util.List;

public class BTreeLevelSum {

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
	
	public static void main(String args[]) {
		int arr[] = new int[] {1, 2, 3, 4, 5, 6, 7};
		Node head = null;
		BTreeLevelSum btree = new BTreeLevelSum();
		for(int i=0; i<arr.length; i++) {
			//head = btree.insert(head, arr[i]);
			head = btree.makeTree(head, arr[i]);
		}
		System.out.print("Inorder - ");
		btree.inOrder(head);
		System.out.println();
		System.out.print("Level Order - ");
		btree.levelOrder(head);
		System.out.println();
		System.out.println("Key is at level - "+btree.getLevelSum(head, 22));
		
	}
	
	public Node insert(Node head, int data) {
		Node node = new Node(data);
		Node temp = head;
		if(temp == null) {
			return node;
		} else {
			if(temp.left == null) {
				temp.left = node;
			} else if(temp.right == null) {
				temp.right = node;
			} else {
				if(temp.left.left == null || temp.left.right == null) {
					insert(temp.left, data);
				} else {
					insert(temp.right, data);
				}
			}
		}
		return head;
	}
	
	public Node makeTree(Node head, int data) {
		Node node = new Node(data);
		Node temp = head;
		if(temp == null) {
			return node;
		} else {
			LinkedList<Node> queue = new LinkedList<>();
			queue.add(temp);
			while(!queue.isEmpty()) {
				temp = queue.poll();
				if(temp.left == null) {
					temp.left = node;
					return head;
				} else {
					queue.add(temp.left);
				}
				if(temp.right == null) {
					temp.right = node;
					return head;
				} else {
					queue.add(temp.right);
				}
			}
		}
		return head;
	}
	
	public void inOrder(Node head) {
		Node temp = head;
		if(temp != null) {
			inOrder(temp.left);
			System.out.print(temp.data+" ");
			inOrder(temp.right);
		}
	}
	
	public void levelOrder(Node head) {
		Node temp = head;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(temp);
		while(!queue.isEmpty()) {
			Node t = queue.poll();
			System.out.print(t.data+" ");
			if(t.left != null ) {
				queue.add(t.left);
			}
			if(t.right != null) {
				queue.add(t.right);
			}
		}
	}
	
	public int getLevelSum(Node head, int key) {
		Node temp = head;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(temp);
		int i = 0;
		while(!queue.isEmpty()) {
			int count = (int) Math.pow(2, i);
			int sum = 0;
			while(count-- > 0) {
				temp = queue.poll();
				if(temp.left != null ) {
					queue.add(temp.left);
				}
				if(temp.right != null) {
					queue.add(temp.right);
				}
				sum += temp.data;
			}
			if(sum == key) {
				//System.out.println(i);
				return i;
			}
			i++;
		}
		return -1;
	}
}
