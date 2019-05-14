package org.java.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class Cars24 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		List<Integer> superSet = new ArrayList<>();
		System.out.println("Enter n :");
		int n = in.nextInt();
		System.out.println("Enter array :");
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		
		System.out.println("Enter k");
		int k = in.nextInt();
		printSubsequences(a, n, k);
		in.close();
	}
	
	 static void printSubsequences(int arr[], int n, int k) 
	    { 
		 List<List<Integer>> list = new ArrayList<>();
	        int opsize = (int)Math.pow(2, n); 
	       
	        for (int counter = 1; counter < opsize; counter++) 
	        { 
	        	List<Integer> seq = new ArrayList<>();
	            for (int j = 0; j < n; j++) 
	            { 
	        
	                if (BigInteger.valueOf(counter).testBit(j))
	                	seq.add(arr[j]);
	            }
	            if(seq.size() == k) {
	            	list.add(seq);
	            }
	        }
	        System.out.println(list);
	        int count = 0;
	        Iterator<List<Integer>> itr = list.iterator();
	        while(itr.hasNext()) {
	        	List<Integer> l = itr.next();
	        	if((l.get(0)) != 0) {
	        		count++;
	        	}
	        }
	        System.out.println(count);
	    }
}
