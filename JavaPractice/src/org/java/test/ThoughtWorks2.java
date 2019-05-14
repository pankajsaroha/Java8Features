package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ThoughtWorks2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<test; t++) {
			int q = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			/*SortedSet<Integer> set = new TreeSet<>();
			for(int i=0; i<q; i++) {
				set.add(Integer.parseInt(st.nextToken()));
				Iterator<Integer> it = set.iterator();
				int j=0;
				int stop = Integer.parseInt(st1.nextToken());
				int n = -1;
				while(it.hasNext()) {
					n = it.next();
					if(++j == stop) {
						break;
					}
				}
				System.out.println(n);
			}*/
			List<Long> list = new ArrayList<>();
			for(int i=0; i<q; i++) {
				list.add(Long.parseLong(st.nextToken()));
				Collections.sort(list);
				System.out.println(list.get((int) (Long.parseLong(st1.nextToken())-1)));
			}
			long arr[] = new long[1000000000];
			for(int i=0; i<q; i++) {
				long n = Long.parseLong(st1.nextToken());
				for(long j=0; j<arr.length; j++) {
					if(arr[i]>n) {
						long temp = arr[i];
						arr[i] = n;
					}
				} 
			}
		}
	}

}
