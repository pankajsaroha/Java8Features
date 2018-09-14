package org.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hashmap<K, V> implements MapTemp<K, V>{
	private static int initialCapacity = 16;
	//public double loadFactor = 0.75;
	private LinkList<K, V> arr[];
	private List<K> keyset = new ArrayList<>();
	private List<V> val = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public Hashmap() {
		this.arr = new LinkList[initialCapacity];
		//this.loadFactor = 0.75;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public int hashCode(K key) {
		String k = key.toString();
		int hash = (int) k.charAt(0);
		return hash;
	}

	@Override
	public boolean put(K key, V value) {
		int hash = hashCode(key);
		int index = hash & (arr.length-1);
		if(arr[index] == null) {
			LinkList<K, V> list = new LinkList<>();
			arr[index] = list.addNew(key, value, list);
			keyset.add(key);
			val.add(value);
		} else {
			LinkList<K, V> list = arr[index];
			Node<K, V> temp = list.head;
			while(temp != null) {
				if(temp.key.equals(key)) {
					temp.value = value;
					return true;
				}
				temp = temp.next;
			}
			keyset.add(key);
			list.add(key, value, list);
		}
		return true;
	}

	@Override
	public V get(K key) {
		int hash = hashCode(key);
		int index = hash & (arr.length-1);
		LinkList<K, V> list = arr[index];
		Node<K, V> temp = list.head;
		V val = null;
		while(temp != null) {
			if(temp.key.equals(key)) {
				val = temp.value;
				break;
			}
			temp = temp.next;
		}		
		return val;
	}

	@Override
	public List<V> values() {
		return val;
	}
	
	@Override
	public List<K> keySet() {
		return keyset;
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		ArrayList<Mapentry> al = new ArrayList<>();
		for(int i=0; i<keyset.size(); i++) {
			al.add(new Mapentry(keyset.get(i), val.get(i)));
		}
		System.out.println("Entry :"+al);
		return null;	
	}
}
