package org.java.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class PriotrityQueueExample{

	public static void main(String args[]) {
		PriorityQueue<String> queue = new PriorityQueue<String>(new MyComparator());
		
		Hashtable<String, String> tab = new Hashtable<>();
		tab.put("1", "Pankaj");
		tab.put("2", "Manish");
		tab.put("3", "Ankit");
		tab.put("4", "Sakshi");
		tab.put("5", "vishu");
		System.out.println("---HashTable---"); 
		
		Iterator<Map.Entry<String, String>> itr = tab.entrySet().iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			tab.remove("6");
		}
		

		Map<String, String> map = new HashMap<>();
		map.put(null, "Nothing");
		map.put("1", "Pankaj");
		map.put("2", "Manish");
		map.put("3", "Ankit");
		map.put("4", "Sakshi");
		map.put("5", "vishu");
		
		System.out.println("---Map---");
		itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			//map.put("6", "Prince");
		}
		
		TreeMap<String, String> tmap = new TreeMap<>();
		tmap.put("P", "Pankaj");
		tmap.put("M", "Manish");
		tmap.put("A", "Ankit");
		tmap.put("S", "Sakshi");
		
		Set set = tmap.entrySet();
		System.out.println("Tree Entry Set : "+set);
		itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println(map.get(null));
		queue.add("Pankaj");
		queue.add("Manish");
		queue.add("Ankit");
		queue.add("Sakshi");
		queue.add("Neha");
		queue.add("Prince");
		
		while(queue.size() != 0) {
			System.out.println(queue.poll());
		}
	}
}
