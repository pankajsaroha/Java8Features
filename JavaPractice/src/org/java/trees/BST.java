package org.java.trees;

import java.util.LinkedList;
import java.util.Scanner;

public class BST {
	
	/*enum Color {
		red, black;
	}*/
	
	static class Node {
		public int data;
		public Node left;
		public Node right;
		public Node parent;
		public String color;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = null;
			this.color = "red";
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BST bst = new BST();
		Node head = null;
		//int arr[] = new int[] {4, 3, 5, 1, 2, 6, 7};
		int arr[] = new int[] {10, 5, 15, 3, 0};
		for(int i : arr) {
			//head = bst.insertInRBT(head, i);
			head = bst.insert(head, i);
		}
		bst.print(head);
		System.out.println();
		bst.prePrint(head);
		System.out.println();
		bst.postPrint(head);
		System.out.println();
		bst.levelPrint(head);
		in.close();
	}
	
	public Node insert(Node root, int data) {
		Node node = new Node(data);
		if(root == null) {
			return node;
		} else {
			Node temp = root;
			if(data < temp.data) {
				if(temp.left == null) {
					temp.left = node;
				} else {
					insert(temp.left, data);
				}
			} else {
				if(temp.right == null) {
					temp.right = node;
				} else {
					insert(temp.right, data);
				}
			}
		}
		return root;
	} 
	
	public Node insertInRBT(Node root, int data) {
		Node node = new Node(data);
		if(root == null) {
			node.color = "black";
			return node;
		} else {
			Node temp = root;
			if(data < temp.data) {
				if(temp.left == null) {
					node.parent = temp;
					temp.left = node;
					if(node.parent.color.equals("red")) {
						Node grandparent = node.parent.parent;
						Node papa = node.parent;
						if(papa == grandparent.left) {
							if(grandparent.parent == null) {
								Node t = grandparent;
								papa.parent = t.parent;
								t.left = papa.right;
								t.parent = papa;
								papa.right = t;
								grandparent = papa;
								papa.color = "black";
								t.color = "red";
							} else {
								grandparent.parent.left = papa;
								papa.color = "black";
								grandparent.left = papa.right;
								papa.right = grandparent;
								grandparent.color = "red";
							}
						}
						/*if(papa == grandparent.left) {
							Node t = grandparent;
							papa.color = Color.black;
							papa.parent = grandparent.parent;
							grandparent = papa;
							grandparent.right = t;
							t.parent = grandparent;
						}*/
						if(papa == grandparent.right) {
							grandparent.parent.right = node;
							node.color = "black";
							papa.left = node.right;
							grandparent.right = node.left;
							node.right = papa;
							node.left = grandparent;
							grandparent.color = "red";
						}
					}
				} else {
					insertInRBT(temp.left, data);
				}
			} else {
				if(temp.right == null) {
					node.parent = temp;
					temp.right = node;
					Node grandparent = node.parent.parent;
					Node papa = node.parent;
					if(papa.color.equals("red")) {
						if(papa == grandparent.left) {
							grandparent.parent.left = node;
							node.color = "black";
							grandparent.left = node.right;
							papa.right = node.left;
							node.left = papa;
							node.right = grandparent;
							grandparent.color = "red";
						}
						if(papa == grandparent.right) {
							grandparent.parent.right = papa;
							papa.color = "black";
							grandparent.right = papa.left;
							papa.left = grandparent;
							grandparent.color = "red";
						}
					}
				} else {
					insertInRBT(temp.right, data);
				}
			}
		}
		while(root.parent != null) {
			root = root.parent;
		}
		return root;
	}
	
	public Node leftLeftRotation(Node grandparent) {
		return grandparent;
	}
	
	public void print(Node head) {
		Node temp = head; 
		if(temp != null) {
			print(temp.left);
			System.out.print(temp.data+" ");
			print(temp.right);
		}
	}
	
	public void prePrint(Node head) {
		Node temp = head;
		if(temp != null) {
			System.out.print(temp.data+" ");
			prePrint(temp.left);
			prePrint(temp.right);
		}
	}
	
	public void postPrint(Node head) {
		Node temp = head;
		if(temp != null) {
			postPrint(temp.left);
			postPrint(temp.right);
			System.out.print(temp.data+" ");
		}
	}
	
	public void levelPrint(Node head) {
		Node temp = head;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(temp);
		while(!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp.data+" ");
			if(temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
}
