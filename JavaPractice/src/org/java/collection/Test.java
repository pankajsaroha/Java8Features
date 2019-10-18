package org.java.collection;

public class Test{

     public static void main(String args[]) throws Exception{
        //System.out.println(Class.forName("String").getName());
        Hashmap map = new Hashmap<>();
        map.put(11, "Pankaj");
        map.put(12, "Nupur");
        map.put(13, "Saroha");
        System.out.println(map.get(12));
        map.entrySet();
     }
}