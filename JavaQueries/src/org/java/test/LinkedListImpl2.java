package org.java.test;

import java.util.Scanner;

public class LinkedListImpl2 implements Cloneable{
	
	public static void main(String args[]) throws CloneNotSupportedException{
		
		Scanner in = new Scanner(System.in);
		Node head = new Node();
		head = null;
		Node head2 = null;
		LinkedListImpl2 list = new LinkedListImpl2();
		while(true) {
			
			System.out.println("1- Add\n2- Delete\n3- Print\n4- Reverse\n5- Exit");
			int choice = in.nextInt();
		
			switch(choice) {
				
				case 1:
					System.out.print("Enter the value :");
					int value = in.nextInt();
					head = list.add(head, value);
					break;
					
				case 2:
					System.out.print("Enter index :");
					int index = in.nextInt();
					head = list.delete(head, index);
					break;
				
				case 3:
					list.printList(head);
					break;
					
				case 4: 
					//head2 = (Node) head.clone();
					head = list.reverse(head);
					list.printList(head);
					break;
					
				case 5:
					System.out.println("Terminated...");
					return;
					
				default:
					System.out.println("Invalid Input");
					break;
			}
		}
		//in.close();
	}
	
	public Node add(Node head, int value) {
		Node temp = head;
		Node node = new Node();
		node.value = value;
		node.next = null;
		if(temp == null) {
			temp = node;
			head = temp;
		} else {
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		return head;
	}
	
	public Node delete(Node head, int index) {
		Node temp = head;
		if(index <= size(head)){
			if(temp == null) {
			System.out.println("List is empty...");
			} else if (index == 0) {
				System.out.println("Indexing starts at 1");
			} else if(temp.next == null) {
				head = null;
			} else {
				for(int i=0; i<index-2; i++) {
					temp = temp.next;
				}
				temp.next = temp.next.next;
			}
		} else if(size(head) == 0){
			System.out.println("List is empty...");
		} else {
			System.out.println("Index is out of list");
		}
		return head;
	}
	
	public void printList(Node head) {
		Node temp = head;
		if(size(head) == 0) {
			System.out.println("List is empty");
			return;
		}
		while(temp != null) {
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public int size(Node head) {
		int len=0;
		Node temp = head;
		if(temp == null) {
			return 0;
		} else {
			while(temp != null) {
				len = len+1;
				temp = temp.next;
			}
		}
		return len;
	}
	
	public Node reverse(Node head2) {
		Node temp1 = head2;
		Node temp2 = null;
		Node temp3 = null;
		/*if(temp1 == null) {
			System.out.println("List is empty");
			return head2;
		} else if(temp1.next == null) {
			return temp1;
		} else if(temp1.next.next == null){
			temp2 = temp1.next;
			temp1.next = null;
			temp2.next = temp1;
			return temp2;
		} else {*/
			temp2 = temp1.next;
			temp3 = temp2.next;
			temp2.next = temp1;
			temp1.next = null;
			while(temp3 != null) {
				temp1 = temp2;
				temp2 = temp3;
				temp3 = temp2.next;
				
				temp2.next = temp1;
			}
			return temp2;
		//}
	}
}