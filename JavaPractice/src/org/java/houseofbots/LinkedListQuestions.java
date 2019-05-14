package org.java.houseofbots;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListQuestions {
	
	Node head = null;
	
	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		public boolean equals(Node node) {
			return (this.data == node.data) ? true : false;
		}
	}
	
	static class Stack {
		Deque<Integer> stack = new ArrayDeque<>();
		
		public void push(int data) {
			stack.push(data);
		}
		
		public int pop() {
			return stack.poll();
		}
		
		public boolean isEmpty() {
			return stack.isEmpty();
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		LinkedListQuestions list = new LinkedListQuestions();
		String ar[] = in.nextLine().split(" ");
		for(String s : ar) {
			list.insert(Integer.parseInt(s));
		}
		list.printList();
		System.out.println("Middle Element - "+list.getMiddleOnePass());
		//System.out.println(list.makeCycle(ar.length));
		String s = list.containsCycle() ? "contains cycle" : "No Cycle";
		System.out.println(s);
		if(list.containsCycle()) {
			list.firstNodeOfLoop();
		}
		//list.reverseList();
		//list.printList();
		//System.out.println(list.nthElementFromTail(8));
		//list.duplicatesRemoval();
		//list.printList();
		list.getSumOfTwoLists();
		in.close();
	}
	
	public void insert(int data) {
		Node temp = head;
		Node node = new Node(data);
		if(temp == null) {
			head = node;
		} else {
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public int getMiddleOnePass() {
		Node p1 = head;
		Node p2 = head;
		while(p2.next != null && p2.next.next != null) {
			p2 = p2.next.next;
			p1 = p1.next;
		}
		return p1.data;
	}
	
	public boolean containsCycle() {
		Node p1 = head;
		Node p2 = head;
		while(p2.next != null && p2.next.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}
	
	public String makeCycle(int len) {
		int n = len/2;
		Node temp = head;
		Node p = null;
		if(len == 1) {
			temp.next = temp;
		} else if(n > 1) {
			for(int i=0; i<len-1; i++) {
				temp = temp.next;
				if(i==n) {
					p = temp;
				}
			}
			temp.next = p;
		} else {
			return "Please insert elements in the list";
		}
		return "Cycle created";
	}
	
	public void firstNodeOfLoop() {
		Node p1 = head;
		Node p2 = head;
		while(p2.next != null && p2.next.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2) {
				break;
			}
		}
		p1 = head;
		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println(p1.data);
	}
	
	public void reversed() {
		Node previous = null;
		Node current = head;
		Node nextOne = null;
		while(current != null) {
			nextOne = current.next;
			current.next = previous;
			previous = current;
			current = nextOne;
		}
		head = previous;
	}
	/*Node previous = null;
	Node current = head;
	Node nextOne = null;
	
	public void reversedRecursion(Node current) {
		if(current == null) {
			head = previous;
			return;
		} else {
			nextOne = current.next;
			current.next = previous;
			previous = current;
			current = nextOne;
			reversedRecursion(current);
		}
	}*/
	
	public void reverseList() {
		//reversedRecursion(head);
		reverseRecursively(head);
	}
	
	public void reverseRecursively(Node node) {
		Node newHead;
		
		if(node.next == null) {
			head = node;
			//return node;
			return;
		}
		
		//newHead = reverseRecursively(node.next);
		reverseRecursively(node.next);
		
		node.next.next = node;
		node.next = null;
		//return newHead;
	}
	
	public int nthElementFromTail(int n) {
		Node p1 = head;
		Node p2 = head;
		int count = 0;
		while(p2 != null) {
			if(count < n) {
				p2 = p2.next;
			} else {
				p2 = p2.next;
				p1 = p1.next;
			}
			count++;
		}
		if(p1 == null || count < n) {
			System.out.println("Index out of list");
			return -1;
		}
		return p1.data;
	}
	
	public void duplicatesRemoval() {
		Node p1 = head;
		Node p2 = null;
		while(p1 != null && p1.next != null) {
			Node previous = p1;
			p2 = p1.next;
			while(p2 != null) {
				if(p1.equals(p2)) {
					previous.next = p2.next;
				} else {
					previous = p2;
				}
				p2 = p2.next;				
			}
			p1 = p1.next;
		}
	}
	
	public void getSumOfTwoLists() {
		List<Integer> list1 = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();
		list1.add(9);
		list1.add(9);
		list1.add(9);
		list1.add(7);
		list1.add(1);
		list2.add(9);
		list2.add(9);
		list2.add(8);
		sumOfTwoListUsingStack(list1, list2);
	}
	
	public void sumOfTwoListUsingStack(List<Integer> list1, List<Integer> list2) {
		int sum = 0;
		int carry = 0;
		
		List<Integer> result = new LinkedList<>();
		
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		Stack stack3 = new Stack();
		
		for(Integer l : list1) {
			stack1.push(l);
		}
		for(Integer l : list2) {
			stack2.push(l);
		}
		
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			int x = stack1.pop();
			int y = stack2.pop();
			sum = ((x+y+carry)%10);
			carry = (x+y+carry)/10;
			stack3.push(sum);
		}
		
		while(!stack1.isEmpty()) {
			int x = stack1.pop();
			sum = (x+carry)%10 ;
			carry = (x+carry)/10;
			stack3.push(sum);
		}
		
		while(!stack2.isEmpty()) {
			int y = stack2.pop();
			sum = (y+carry)%10;
			carry = (y+carry)/10;
			stack3.push(sum);
		}
		
		stack3.push(carry);
		
		while(!stack3.isEmpty()) {
			result.add(stack3.pop());
		}
		
		for(Integer l : result) {
			System.out.print(l);
		}
	}
}
