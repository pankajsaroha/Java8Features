package org.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class AmericanExpressTest1 {
	
	static ArrayList list = new ArrayList<>();

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter n and k");
		int n = in.nextInt();
		int k = in.nextInt();
		System.out.println("Array : ");
		int arr[] = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		int res = 0;
		subSequences(arr, n, k, 0);
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			int a[] = (int[]) itr.next();
			int gcd = GCD(a, a.length, k);
			int sum = 0;
			for(int i=0; i<a.length; i++) {
				sum = sum+a[i];
			}
			res = res+(sum*gcd);
		}
		System.out.println(res);
	}
	
	public static int GCD(int arr[], int n, int k) {
		
		Arrays.sort(arr);
		int high = arr[n-1];
		
		int divisors[] = new int[high+1];
		
		for(int i=0; i<n; i++) {
			for(int j=1; j<Math.sqrt(arr[i]); j++) {
				if(arr[i]%j == 0) {
					divisors[j]++;
					
					if(j != arr[i] / j)
						divisors[arr[i] / j]++;
				}
			}
		}
		
		for(int i=high; i>=1; i--) {
			if(divisors[i] >= k)
				return i;
		}
		
		return 0;
	}
	
	public static void subSequences(int arr[], int n, int k, int index) {
		int i;
		if(k==0) {
			list.add(arr);
		}
		if(k > 0) {
			for(i = 1; i<n; ++i)
		      {
		        arr[index] = i;
		        subSequences(arr, n, k-1, index+1);
		      }
		}
	}
	
	static int getSuccessor(int arr[], int k, int n) {
	    int p = k - 1;
	    while (arr[p] == n)
	        p--;
	    if (p < 0)
	        return 0;
	 
	    arr[p] = arr[p] + 1;
	    for(int i = p + 1; i < k; i++)
	        arr[i] = 1;
	 
	    return 1;
	}
	
	static void printSequences(int n, int k)
	{
	    int arr[] = new int[k];
	 
	    for(int i = 0; i < k; i++)
	        arr[i] = 1;
	 
	    while(true)
	    {
	        list.add(arr);
	 
	        if(getSuccessor(arr, k, n) == 0)
	          break;
	    }
	    return;
	}
	
}
