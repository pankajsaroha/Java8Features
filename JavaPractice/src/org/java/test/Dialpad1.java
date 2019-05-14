package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import java.util.Map;
import java.util.HashMap;

public class Dialpad1 {
	
	/*
	 *  input - 1
	 *			143624987163591683761087351209873650817648716
	 *	output - 78
	 *
	 *	input - 2
	 *			1515732322
	 *			1351355246246
	 *	output - 3
	 *			 5
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<test; t++) {
			String num[] = br.readLine().split("");
			int a[] = new int[10];
			int b[] = new int[10];
			
			for(int i=0; i<num.length; i++) {
				int n = Integer.parseInt(num[i]);
				a[n] = a[n]+1;
			}
		}
		
		
		
		/*for(int t=0; t<test; t++) {
			String num[] = br.readLine().split("");
			LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
			for(int i=0; i<num.length; i++) {
				if(map.containsKey(num[i])) {
					map.put(num[i], map.get(num[i])+1);
				} else {
					map.put(num[i], 1);
				}
			}
			int count = 0;
			Map<String, Boolean> trace = new HashMap<>();
			for(Entry<String, Integer> entry : map.entrySet()) {
				int n = Integer.parseInt(entry.getKey());
				int val1 = entry.getValue(); 
				trace.put(entry.getKey(), true);
				if(map.containsKey(n+1+"") && (trace.get(n+1+"") == null || trace.get(n+1+"") == false)) {
					int val2 = map.get(n+1+"");
					
					int cal1 = factorial(val1) / (factorial(val1-2) * 2);
					int cal2 = factorial(val2) / (factorial(val2-2) * 2);
					count = count + (cal1 + cal2);
				}
			}
			System.out.println(count);
		}*/
	}
	
	static int factorial(int n) 
    { 
        if (n == 0) 
          return 1; 
          
        return n*factorial(n-1); 
    }

}
