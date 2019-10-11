package org.java.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HotstarTest1 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		HotstarTest1 hotstar = new HotstarTest1();
		System.out.println("Test cases :");
		int testCases = in.nextInt();
		System.out.println("n :");
		int n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Array :");
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(hotstar.equalityCheck(arr, arr.length));
		//System.out.println(decToBinary(96));
 	}
	
	public int equalityCheck(int arr[], int n) {
		/*int len = arr.length;
		int n = len/3;
		int sum = 0;
		int dec = binaryToDecimal(arr)/3;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 1) {
				sum = sum+1;
			}
		}
		if(sum%3 == 0) {
			return sum/3;
		}*/
		int noOf1 = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == 1) {
				noOf1 = noOf1+1;
			}
		}
		if(noOf1%3 ==0 ) {
			int rem = noOf1/3;
			/*int maxsizeofpart = (n/3) + rem;
			int minsizeofpart = n/3;
			int a[] = new int[minsizeofpart];*/
			int noof1bit = 0;
			int find1 = n-1;
			LinkedList<Integer> l = new LinkedList<Integer>();
			while(noof1bit != rem) {
				l.addFirst(arr[find1]);
				if(arr[find1] == 1) {
					noof1bit = noof1bit+1;
				}
				find1 = find1 - 1;
			}
			Integer[] a = l.toArray(new Integer[l.size()]);
			//System.out.println(binaryToDecimal(a));
			int firstPartDecimal = binaryToDecimal(a);
			l = new LinkedList<Integer>();
			int find2 = 0;
			noof1bit = 0;
			while(noof1bit != rem) {
				l.add(arr[find2]);
				if(arr[find2] == 1) {
					noof1bit = noof1bit+1;
				}
				find2 = find2 + 1;
			}
			a = l.toArray(new Integer[l.size()]);
			while(binaryToDecimal(a) != firstPartDecimal) {
				l.add(arr[find2]);
				find2 = find2 + 1;
				a = l.toArray(new Integer[l.size()]);
			}
			int secondPartDecimal = binaryToDecimal(a);
			//System.out.println(secondPartDecimal);
			l = new LinkedList<Integer>();
			a = l.toArray(new Integer[l.size()]);
			while(find2 <= find1) {
				if(binaryToDecimal(a) != firstPartDecimal) {
					l.add(arr[find2]);
					find2 = find2 + 1;
					a = l.toArray(new Integer[l.size()]);
				} else {
					return binaryToDecimal(a)%1000000007;
				}
			}
			if(find2 <= find1) {
				return binaryToDecimal(a)%1000000007;
			}
			/*int firstPartDecimal = binaryToDecimal(a);
			System.out.println(firstPartDecimal);*/
		}
		return -1;
	}
	
	public int binaryToDecimal(Integer a[]) {
		int len = a.length;
		int dec = 0;
		for(int i=0; i<len; i++) {
			dec = dec+a[len-1-i]* ((int) Math.pow(2, i));
		}
		return dec;
	}
	
	static int decToBinary(int n)
    {
        // array to store binary number
        int[] binaryNum = new int[1000];
  
        // counter for binary array
        int i = 0;
        while (n > 0) 
        {
            // storing remainder in binary array
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
  
        String bin = "";
        // printing binary array in reverse order
        for (int j = i - 1; j >= 0; j--)
            bin = bin+ binaryNum[j];
        
        return Integer.valueOf(bin);
    }
}
