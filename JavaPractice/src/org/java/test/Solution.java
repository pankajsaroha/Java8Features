package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	static List<Integer> freqQuery(int[][] queries) {
		Map<Integer, Integer> map = new HashMap<>();
	    Map<Integer, Integer> occurence = new HashMap<>();
	    List<Integer> frequencies = new ArrayList<>();
	    
	    int freq;
	    int oc;
	    int newFreq;
	    int newOc;
	    
	    for(int[] query : queries) {
	    	int x = query[0];
	    	int y = query[1];
	    	
	    	freq = map.get(y)==null ? 0 : map.get(y);
	    	oc = occurence.get(freq)==null ? 0 : occurence.get(freq);
	    	
	    	if(x==1) {
	    		newFreq = freq+1;
	    	} else {
	    		newFreq = freq-1;
	    	}
	    	
	    	if(newFreq < 1) {
	    		map.remove(y);
	    	} else {
	    		map.put(y, newFreq);
	    	}
	    	
	    	newOc = occurence.get(newFreq) == null ? 0 : occurence.get(newFreq);
	    	
	    	if(--oc < 1) {
	    		occurence.remove(freq);
	    	} else {
	    		occurence.put(freq, oc);
	    	}
	    	
	    	occurence.put(newFreq, newOc+1);
	    	
	    	if(x == 3) {
	    		frequencies.add(occurence.get(y)==null ? 0 : 1);
	    	}
	    }
	    
	    return frequencies;
	}
	
	public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];
            //List<int[]> queries = new ArrayList<>();
            		
            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
                /*int query[] = new int[2];
                query[0] = Integer.parseInt(qry[0]);
                query[1] = Integer.parseInt(qry[1]);
                queries.add(query);*/
            }

            List<Integer> ans = freqQuery(queries);

            for(Integer i : ans) {
            	System.out.println(i);
            }
        }
    }
}
