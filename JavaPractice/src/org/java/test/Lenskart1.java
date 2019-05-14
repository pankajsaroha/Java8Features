package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lenskart1 {

	/*
	 * public static void main(String args[]) throws IOException { BufferedReader br
	 * = new BufferedReader(new InputStreamReader(System.in)); int testCases =
	 * Integer.parseInt(br.readLine().trim()); for (int t = 0; t < testCases; t++) {
	 * int n = Integer.parseInt(br.readLine().trim()); long arr[] = new long[n];
	 * String a[] = br.readLine().split(" "); Map<Long, Integer> map = new
	 * HashMap<>(); for (int i = 0; i < n; i++) { arr[i] = Long.parseLong(a[i]);
	 * map.put(arr[i], 0); } Lenskart1 lens = new Lenskart1(); map =
	 * lens.subsequences(arr, map); //List<Long> charged = new ArrayList<>(); long
	 * sum = 0; for(int i=0; i<n; i++) { int count = 0; for(List<Long> l : list) {
	 * if(l.contains(arr[i])) { ++count; } } if((count<=arr[i])) { sum =
	 * (sum+arr[i])%1000000007; } } long sum = 0; for(Map.Entry<Long, Integer> entry
	 * : map.entrySet()) { if(entry.getKey() >= entry.getValue()) { sum =
	 * (sum+entry.getKey())%1000000007; } } System.out.println(sum); } br.close(); }
	 */

	/*
	 * public List<List<Long>> subsequences(long arr[]) { int opsize = (int)
	 * Math.pow(2, arr.length); List<List<Long>> list = new ArrayList<>(); for (int
	 * counter = 1; counter < opsize; counter++) { List<Long> list2 = new
	 * ArrayList<>(); for (int j = 0; j < arr.length; j++) { if
	 * (BigInteger.valueOf(counter).testBit(j)) { list2.add(arr[j]); } }
	 * list.add(list2); } return list; }
	 */

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 0; t < testCases; t++) {
			int n = in.nextInt();
			long arr[] = new long[n];
			long sum = 0;
			// String a[] = br.readLine().split(" ");
			// Map<Long, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				// arr[i] = Long.parseLong(a[i]);
				arr[i] = in.nextLong();
				if (arr[i] >= Math.pow(2, arr.length - 1)) {
					sum = (sum + arr[i]) % 1000000007;
				}
				// map.put(arr[i], 0);
			}
			/*
			 * TestClass lens = new TestClass(); map = lens.subsequences(arr, map);
			 */

			/*
			 * for(Map.Entry<Long, Integer> entry : map.entrySet()) { if(entry.getKey() >=
			 * entry.getValue()) { sum = (sum+entry.getKey())%1000000007; } }
			 */

			System.out.println(sum);
		}

	}

	public Map<Long, Integer> subsequences(long arr[], Map<Long, Integer> map) {
		int opsize = (int) Math.pow(2, arr.length);
		for (int counter = 1; counter < opsize; counter++) {
			for (int j = 0; j < arr.length; j++) {
				if (BigInteger.valueOf(counter).testBit(j)) {
					map.put(arr[j], map.get(arr[j]) + 1);
				}
			}
		}
		return map;
	}

	public void printAllSubsets(int... arr) {
		int size = arr.length;
		int binaryLimit = (1 << size) - 1;

		for (int i = 1; i <= binaryLimit; i++) {
			int index = size - 1;
			int num = i;
			while (num > 0) {
				if ((num & 1) == 1) {
					System.out.print(arr[index] + " ");
				}
				index--;
				num >>= 1;
			}
			System.out.println();
		}
	}
}
