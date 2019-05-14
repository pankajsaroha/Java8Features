package org.java.practice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WissenDhokha {

	public int stairCases(int blocks) {
		int n = 0;
		int i = 1;
		while(n <= blocks) {
			n = n+i;
			i++;
		}
		
		return i-2;
	}
	
	public Set<Integer> maxProduct(int arr[]) {
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<>();
		int n = arr.length;
		if(arr.length >= 2) {
			int prod1 = arr[n-1] * arr[n-2];
			int prod2 = arr[0] * arr[1];
			
			if(Math.abs(prod1) > Math.abs(prod2)) {
				set.add(arr[n-1]);
				set.add(arr[n-2]);
			} else {
				set.add(arr[0]);
				set.add(arr[1]);
			}
			return set;
		}
		return null;
	}
	
	public boolean palindrome(String str) {
		char s[] = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s.length; i++) {
			if(map.containsKey(s[i])) {
				map.put(s[i], map.get(s[i])+1);
			} else {
				map.put(s[i], 1);
			}
		}
		
		int charLenOne = 0;
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				charLenOne++;
				if(charLenOne > 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public String longestWord(String str) {
		String s[] = str.split(" ");
		String output = "";
		int len = Integer.MIN_VALUE;
		for(int i=0; i<s.length; i++) {
			String word = s[i];
			if(word.contains(".") || word.contains(",")) {
				word = word.replace(".", "");
				word = word.replace(",", "");
			}
			if(word.length() > len && word.length()%2 == 0) {
				len = word.length();
				output = word;
			}
		}
		return output;
	}
	
	class Order {
		int orderId;
		LocalTime time;
		
		public Order(int orderId, LocalTime time) {
			this.orderId = orderId;
			this.time = time;
		}
		
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public LocalTime getTime() {
			return time;
		}
		public void setTime(LocalTime time) {
			this.time = time;
		}
		
		@Override
		public String toString() {
			return "OrderId - "+this.orderId+" Time Of Entry "+this.time;
		}
	}
	
	public Collection<Order> loadOrder() {
		Set<Order> treeSet = new TreeSet<>(new OrderComparator());
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		treeSet.add(new Order(1, LocalTime.parse("10:15:00", dateTimeFormatter)));
		treeSet.add(new Order(3, LocalTime.parse("09:30:00", dateTimeFormatter)));
		treeSet.add(new Order(2, LocalTime.parse("11:29:00", dateTimeFormatter)));
		treeSet.add(new Order(3, LocalTime.parse("13:30:00", dateTimeFormatter)));
		
		return treeSet;
	}
	
	public Collection<Order> search(LocalTime startTime, LocalTime endTime) {
		TreeSet<Order> treeSet = (TreeSet<Order>) loadOrder();
		List<Order> list = new ArrayList<>();
		for(Order order : treeSet) {
			if(order.getTime().compareTo(startTime) >= 0  && order.getTime().compareTo(endTime) <= 0) {
				list.add(order);
			}
		}
		return list;
	}
	
	class OrderComparator implements Comparator<Order> {

		@Override
		public int compare(Order order1, Order order2) {
			 return order1.getTime().compareTo(order2.getTime());
		}
		
	}
	
	public static void main(String args[]) {
		WissenDhokha wissen = new WissenDhokha();
		System.out.println("Staircases "+wissen.stairCases(50));
		System.out.println("Max Product +ve "+wissen.maxProduct(new int[] {8, 1, 2, 5 ,6, 0, 7}));
		System.out.println("MaxProduct +ve and -ve "+wissen.maxProduct(new int[] {8, 1, -7, -9 ,-1, 0, 7}));
		System.out.println("Rotator palindrome "+wissen.palindrome("rrotato"));
		System.out.println("Cricket palindrome "+wissen.palindrome("cricket"));
		String sentence = "Be not afraid of greatness. Some are born great, some achieve greatness, and others have greatness thrust upon them.";
		System.out.println("Longest word in sentence is "+wissen.longestWord(sentence));
		System.out.println("Load Order data "+wissen.loadOrder());
		System.out.println("Order between 9:30 to 11:30 "+wissen.search(LocalTime.parse("09:30"), LocalTime.parse("11:30")));
		System.out.println(LocalTime.parse("09:30").compareTo(LocalTime.parse("11:30")));
	}
}
