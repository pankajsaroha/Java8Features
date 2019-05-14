package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RebelFoods2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String days[] = br.readLine().split(" ");
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(days[i]));
		}
		RebelFoods2 rf = new RebelFoods2();
		int cost = rf.solution(list, 0);
		if(cost > 2499) {
			System.out.println(2499);
		} else {
			System.out.println(cost);
		}
		br.close();
	}
	
	public int solution(List<Integer> list, int cost) {
		if(list.size() == 1) {
			return cost + 199;
		} else if(list.size() == 2) {
			return cost + 199*2;
		} else if(list.size() == 3) {
			return cost + 199*3;
		} else if(list.size()>23) {
			return 2499;
		} else {
			int j = 0;
			int i = 0;
			while(i<=list.size() && j<list.size()) {
				if((list.get(j)-list.get(i) < 7)) {
					j++;
				} else {
					
					if(list.subList(i, j).size() == 1) {
						cost += 199;
					} else if(list.subList(i, j).size() == 2) {
						cost += 199*2;
					} else if(list.subList(i, j).size() == 3) {
						cost += 199*3;
					} else {
						cost += 699;
					}
					return solution(list.subList(j, list.size()), cost);
				}
			}
			return cost+699;
		}
	}

}
