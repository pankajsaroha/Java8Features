package org.java.test;

import java.util.Scanner;

public class LinkedListImpl implements Cloneable{
	
	public static void main(String args[]) throws CloneNotSupportedException{
		
		Scanner in = new Scanner(System.in);
		Node head = new Node();
		head = null;
		Node head2 = null;
		LinkedListImpl list = new LinkedListImpl();
		while(true) {
			
			System.out.println("1- Add\n2- Delete\n3- Print\n4- Reverse\n5- Get size\n6- Search element\n7- Sort\n8- Exit");
			int choice = in.nextInt();
		
			switch(choice) {
				
				case 1:
					System.out.println("Where\n	1- At End\n	2- At Begining\n	3- At given index");
					int add_Cont = in.nextInt();
					switch(add_Cont) {
						
						case 1:
							System.out.print("Enter the value :");
							int value = in.nextInt();
							head = list.add(head, value);
							break;
							
						case 2:
							System.out.print("Enter the value :");
							value = in.nextInt();
							head = list.addAtBegining(head, value);
							break;
							
						case 3:
							System.out.print("Enter the value :");
							value = in.nextInt();
							System.out.print("index : ");
							int index = in.nextInt();
							head = list.addAtGivenIndex(head, value, index);
							break;
							
						default:
							System.out.println("Invalid Input");
							break;
					}
					break;
					
				case 2:
					System.out.println("Which one\n	1- First\n	2- Last\n	3- At given index");
					int del_Cont = in.nextInt();
					switch(del_Cont) {
						case 1:
							head = list.deleteFirst(head);
							break;
							
						case 2:
							head = list.deleteLast(head);
							break;
							
						case 3:
							System.out.print("Enter index :");
							int index = in.nextInt();
							head = list.delete(head, index);
							break;

						default:
							System.out.println("Invalid Input !!!");
							break;
					}
					break;					
				
				case 3:
					list.printList(head);
					break;
					
				case 4: 
					head = list.reversedByRecursion(head);
					list.printList(head);
					break;
					
				case 5:
					System.out.println("Length of list is: "+list.sizeByRecursion(head));
					break;
					
				/*case 6:
					System.out.println("Enter element :");
					int value = in.nextInt();
					int index = list.search(head, value);
					break;*/
					
				case 6:
					System.out.println("Enter element :");
					int value = in.nextInt();
					int index = list.searchByRecursion(head, value);
					if(index == 0) {
						System.out.println("Element not found.");
					} else {
						System.out.println("Your element is at :"+index);
					}
					break;
					
				case 7:
					head = list.sort(head);
					System.out.println("Sorted...");
					break;
					
				case 8:
					System.out.println("Terminating...");
					System.out.println("Thanks for using !!!");
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
	
	public Node addAtBegining(Node head, int value) {
		Node temp = head;
		Node node = new Node();
		node.value = value;
		node.next = null;
		if(temp == null) {
			return node;
		} else {
			node.next = temp;
			return node;
		}
	}
	
	public Node addAtGivenIndex(Node head, int value, int index) {
		Node temp = head;
		Node node = new Node();
		node.value = value;
		node.next = null;
		if(index == 0) {
			System.out.println("Indexing starts at 1.");
			return head;
		}
		if(index <=size(head)) {
			if(temp == null) {
				return node;
			}else if(temp.next == null && index == 1) {
				node.next = temp;
				head = node;
			}else {
				for(int i=0; i<index-2; i++) {
					temp = temp.next;
				}
				node.next = temp.next;
				temp.next = node;
			}
		} else if(size(head) == 0) {
			head = addAtBegining(head, value);
		} else {
			System.out.println("Index is out of list");
		}
		return head;
	}
	
	public Node deleteFirst(Node head) {
		Node temp = head;
		if(temp == null) {
			System.out.println("List is empty.");
		} else {
			head = temp.next;
		}
		return head;
	}
	
	public Node deleteLast(Node head) {
		Node temp = head;
		if(temp == null) {
			System.out.println("List is empty.");
		} else if(temp.next == null) {
			head = null;
		} else {
			while(temp.next != null) {
				temp = temp.next;
			}
			temp = null;
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
	
	public int sizeByRecursion(Node head) {
		int len = 0;
		Node temp = head;
		if(temp == null) {
			return len;
		} else {
			len = len+1;
			return len+sizeByRecursion(temp.next);
		}
	}
	
	public Node reverse(Node head) {
		Node temp1 = head;
		Node temp2 = null;
		Node temp3 = null;
		if(temp1 == null) {
			System.out.println("List is empty");
			return head;
		} else if(temp1.next == null) {
			return temp1;
		} else if(temp1.next.next == null){
			temp2 = temp1.next;
			temp1.next = null;
			temp2.next = temp1;
			return temp2;
		} else {
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
		}	
	}
	
	public Node reversed(Node head) {
		Node temp1 = null;	//previous
		Node temp2 = head;	//current
		Node temp3 = null;	//next
		while(temp2 != null) {
			temp3 = temp2.next;
			temp2.next = temp1;
			temp1 = temp2;
			temp2 = temp3;
		}
		return temp1;
	}
	
	public Node reversedByRecursion(Node head) {
		Node temp1 = head;
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		Node temp2 = temp1.next;
		temp1.next = null;
		Node temp = reversedByRecursion(temp2);
		temp2.next = temp1;
		return temp;
	}
	
	public int search(Node head, int value) {
		Node temp = head;
		int index = 0;
		while(temp != null) {
			index = index+1;
			if(temp.value == value) {
				System.out.println("Your element is at index "+index);
				return index;
			}
			temp = temp.next;
		}
		System.out.println("Element not found");
		return index;
	}
	
	/*public int searchByRecursion(Node head, int value) {
		Node temp = head;
		int index = 0;
		if(temp == null){
			return index;
		} else {
			index = index+1;
			if(temp.value == value) {
				return index;
			} else {
				index = index+searchByRecursion(temp.next, value);
			}
		}
		return index;
	}*/
	
	public int searchByRecursion(Node head, int value) {
		Node temp = head;
		int index = 0;
		
		if(temp == null)
			return index;
		
		if(temp.value == value)
			return index+1;
		
		index = index+1;
		
		return index+searchByRecursion(temp.next, value);
	}
	
	public Node sort(Node head) {
		Node previous = head;
		Node current = head;
		Node next_node = null;
		int len = size(head);
		if(current == null){
			System.out.println("List is empty");
			return head;
		}
		for(int i=1; i<len; i++) {
			for(int j=0; j<len-i; j++) {
				next_node = current.next;
				if(current.value > next_node.value){
					if(current == head) {
						head = next_node;
						previous = head;
					}
					current.next = next_node.next;
					next_node.next = current;
					previous.next = next_node;
					previous = next_node;
					previous.next = current;
				} else {
					previous = current;
					current = current.next;					
				}
			}
			current = head;
		}
		return head;
	}
}