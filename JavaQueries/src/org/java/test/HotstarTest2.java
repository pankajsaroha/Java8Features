package org.java.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotstarTest2 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Test cases :");
		int testCases = in.nextInt();
		for (int test = 0; test < testCases; test++) {
			System.out.println("n :");
			int n = in.nextInt();
			HashMap<String, ArrayList<Integer>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				System.out.println("key :");
				String key = in.next();
				if (!map.containsKey(key)) {
					ArrayList<Integer> arr = new ArrayList<>();
					System.out.println("value :");
					arr.add(in.nextInt());
					map.put(key, arr);
				} else {
					System.out.println("value : ");
					map.get(key).add(in.nextInt());
					Collections.sort(map.get(key));
					Collections.reverse(map.get(key));
				}
			}
			HashMap<String, Integer> map2 = new HashMap<>();
			for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
				ArrayList<Integer> totalSpent = entry.getValue();
				int spend = 0;
				if (totalSpent.size() == 1) {
					spend = totalSpent.get(0);
				} else if (totalSpent.size() == 2) {
					spend = totalSpent.get(0) + totalSpent.get(1);
				} else {
					spend = totalSpent.get(0) + totalSpent.get(1) + totalSpent.get(2);
				}
				map2.put(entry.getKey(), spend);
			}
			int max = 0;
			String fes = null;
			for (Map.Entry<String, Integer> entry : map2.entrySet()) {
				int spend = entry.getValue();
				String festival = entry.getKey();
				if (spend > max) {
					fes = festival;
					max = spend;
				}
				if (spend == max) {
					if (fes.compareTo(festival) > 0) {
						fes = festival;
					}
				}
			}

			System.out.println(fes + " " + max);
		}
	}
}
