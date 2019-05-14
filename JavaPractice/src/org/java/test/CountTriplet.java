package org.java.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplet{
    
    static void countTriplet(List<Long> arr, long r) {
        Map<Long, Long> map1 = new HashMap<>();
        Map<Long, Long> map2 = new HashMap<>();
        long count = 0;
        /* --- Solution 1
          for(int i = arr.size() - 1; i>=0; i--) {
            long a = arr.get(i);
            
            if(map2.containsKey(a*r)) {
                count += map2.get(a*r);
            }
            
            if(map1.containsKey(a*r)) {
                long c = map1.get(a*r);
                map2.put(a, map2.getOrDefault(a, 0L) + c);
            }
            
            map1.put(a, map1.getOrDefault(a, 0L) + 1);
        }*/
        for(Long a : arr) {
    		count += map2.getOrDefault(a, 0L);
    		if (map1.containsKey(a)){
    			map2.put(a*r, map2.getOrDefault(a*r, 0L) + map1.get(a));
    		}
    		map1.put(a*r, map1.getOrDefault(a*r, 0L) + 1);
    	}
        System.out.println(count);
    }

     public static void main(String []args) throws IOException {
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        //long ans = countTriplets(arr, r);
        long a[] = new long[arrItems.length];
        //System.out.println(String valueOf(ans));
        for(int i=0; i<arrItems.length; i++) {
            a[i] = Long.parseLong(arrItems[i]);
        }
        countTriplet(arr, r);
        bufferedReader.close();
     }
}