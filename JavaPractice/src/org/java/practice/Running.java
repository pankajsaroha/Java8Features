package org.java.practice;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Running {

	public static void main(String args[]) {

        Set<Integer> set = new HashSet<>();
        set.add(null);
        System.out.println(set);
        
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Name", "Pankaj");
        map.put("Name", "Prince");
	}
}
