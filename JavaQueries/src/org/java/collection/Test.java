package org.java.collection;

import java.util.HashMap;
import java.util.Map;

public class Test{

     public static void main(String args[]) throws Exception{
        //System.out.println(Class.forName("String").getName());
    	 Hashmap<Integer, String> map = new Hashmap<>();
    	 map.put(11, "Pankaj");
		 map.put(16, "Saideep");
		 map.put(2, "Anmol");
		 map.put(3, "Divya");
    	 map.put(1, "Nupur");
    	 System.out.println(map.get(2));
    	 Map<Integer, String> mp = new HashMap<>();
    	 System.out.println(mp.get(1));
     }
}