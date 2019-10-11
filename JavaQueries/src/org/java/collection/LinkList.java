package org.java.collection;

public class LinkList<K, V> {

	Node<K, V> node = new Node<>();
	Node<K, V> head = null;
	
	public LinkList<K, V> addNew(K key, V value, LinkList<K, V> list) {
		Node<K, V> node = new Node<K, V>();
		node.key = key;
		node.value = value;
		node.next = null;
		head = node;
		return list;
	}
	
	public LinkList<K, V> add(K key, V value, LinkList<K, V> list) {
		Node<K, V> temp = list.head;
		Node<K, V> node = new Node<K, V>();
		node.key = key;
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
		return list;
	}
}
