package org.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Expedia1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Long> arr = new ArrayList<>();
		List<Long> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr.add(in.nextLong());
		}
		int k = in.nextInt();
		list.add(arr.get(0));
		long next = arr.get(0) * k;
		int index = arr.indexOf(next);
		while(index != -1 && index < arr.size()) {
			if(arr.contains(next)) {
				list.add(next);
			}
			next = next*k;
			index = arr.indexOf(next);
		}
		System.out.println(list.size());
		in.close();
	}

}
