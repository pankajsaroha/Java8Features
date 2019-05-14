package org.java.test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HelloWorld {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(int[][] queries) {

		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> occurence = new HashMap<>();
		List<Integer> freq = new ArrayList<>();
		for (int[] list : queries) {
			int x = list[0];
			int y = list[1];
			if (x == 1) {
				map.merge(y, 1, (a, b) -> a + b);
				occurence.merge(map.get(y), 1, (a, b) -> a+b);
			} else if (x == 2) {
				// int val = (map.containsKey(y)) ? map.get(y) : 0;
				int val = map.get(y) == null ? 0 : map.get(y);
				if (val <= 0) {
					map.remove(map.get(y));
				} else {
					int key = map.get(y);
					occurence.merge(key, 1, (a, b) -> a-1);
					if(occurence.get(key) < 1) {
						occurence.remove(key);
					}
					map.merge(y, val, (a, b) -> a - 1);
					if(map.get(y) < 1) {
						map.remove(y);
					}
				}
			} else {
				freq.add(occurence.get(y) == null ? 0 : 1);
					//freq.add(occurence.get(y) > 0 ? 1 : 0);
			}
		}
		;
		return freq;

	}
	
	static List<Integer> freqQuery(List<int[]> queries) {
	    final Map<Integer, Integer> valueToFreq = new HashMap<>();
	    final Map<Integer, Integer> freqToOccurrence = new HashMap<>();
	    final List<Integer> frequencies = new ArrayList<>();

	    int key;
	    int value;
	    Integer oldFreq;
	    Integer newFreq;
	    Integer oldOccurrence;
	    Integer newOccurrence;
	    for (int[] query : queries) {
	        key = query[0];
	        value = query[1];
	        if (key == 3) {
	            if (value == 0) {
	                frequencies.add(1);
	            }
	            frequencies.add(freqToOccurrence.get(value) == null ? 0 : 1);
	        } else {
	            oldFreq = valueToFreq.get(value);
	            oldFreq = oldFreq == null ? 0 : oldFreq;
	            oldOccurrence = freqToOccurrence.get(oldFreq);
	            oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

	            if (key == 1) {
	                newFreq = oldFreq + 1;
	            } else {
	                newFreq = oldFreq - 1;
	            }
	            newOccurrence = freqToOccurrence.get(newFreq);
	            newOccurrence = newOccurrence == null ? 0 : newOccurrence;

	            if (newFreq < 1) {
	                valueToFreq.remove(value);
	            } else {
	                valueToFreq.put(value, newFreq);
	            }

	            if ((oldOccurrence - 1) < 1) {
	                freqToOccurrence.remove(oldFreq);
	            } else {
	                freqToOccurrence.put(oldFreq, oldOccurrence - 1);
	            }
	            freqToOccurrence.put(newFreq, newOccurrence + 1);
	        }
	    }
	    return frequencies;
	}

	public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());
            //int[][] queries = new int[q][2];
            List<int[]> queries = new ArrayList<>();
            		
            for (int i = 0; i < q; i++) {
                String[] qry = bufferedReader.readLine().split(" ");
                /*queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);*/
                int query[] = new int[2];
                query[0] = Integer.parseInt(qry[0]);
                query[1] = Integer.parseInt(qry[1]);
                queries.add(query);
            }

            List<Integer> ans = freqQuery(queries);

            for(Integer i : ans) {
            	System.out.println(i);
            }
        }
    }
}
