package org.java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonDivisibleSubset {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		findSet(arr, k);
	}

	static void findSet(int arr[], int k) {
		int n = arr.length;
		List<List<Integer>> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			List<Integer> set = new ArrayList<>();
			List<Integer> set2 = new ArrayList<>();
			set.add(arr[i]);
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if ((arr[i] + arr[j]) % k == 0) {
						set2.add(arr[j]);
					} else {
						boolean flag = true;
						for (Integer num : set) {
							if ((num + arr[j]) % k == 0) {
								flag = false;
								break;
							}
						}
						if (flag) {
							set.add(arr[j]);
						}
					}
				}
				if (set.size() > max) {
					max = set.size();
				}
				list.add(set);
			}
		}
		System.out.println("Max = " + max);
		for (List<Integer> s : list)
			System.out.println(s);
	}
}

/*
 * 5 5 2 7 12 17 22
 */
