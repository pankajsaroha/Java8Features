package org.java.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTest {

	public static void main(String args[]) {
		Hashmap<String, String> hash = new Hashmap<>();
		hash.put("Pankaj", "Kumar");
		hash.put("Panky", "Chill");
		System.out.println(hash.get("Pankaj"));
		hash.put("Chatty", "Shadi");
		hash.put("Pankaj", "Saroha");
		System.out.println(hash.get("Panky"));
		System.out.println(hash.get("Pankaj"));
		System.out.println(hash.get("Chatty"));
		
		Hashmap<Integer, String> hash2 = new Hashmap<>();
		hash2.put(1, "1");
		System.out.println(hash2.get(1));
		hash.put("Saideep", "Bhai ki shadi");
		System.out.println(hash.get("Pankaj"));
		System.out.println(hash.get("Saideep"));
		
		System.out.println("Hash KeySet :"+hash.keySet());
		System.out.println("Hash Values :"+hash.values());
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		System.out.println(map.entrySet());
		
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		System.out.println(hash.entrySet());
		System.out.println(map.entrySet());
	}
}
