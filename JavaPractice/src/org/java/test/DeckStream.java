package org.java.test;

import java.util.*;
import java.util.stream.Collectors;
public class DeckStream {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            if(i >= m-1) {
            	int count = deque.stream().distinct().collect(Collectors.toList()).size();
            	if(max < count) {
            		max = count;
            	}
            	deque.remove();
            }
        }
        
        System.out.println(max);
    }
}



