package org.java.collection;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetProperties {

	public static void main(String[] args) {
		
		NavigableSet<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(5);
		set.add(2);
		set.add(9);
		set.add(7);
		Iterator<Integer> itr = set.descendingIterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println(set.toString());
		
		
		Person p1 = new Person(25, "Pankaj");
		Person p2 = new Person(25, "Pankaj");
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p1.equals(p2));
	}
	
}

class Person {
	int age;
	String name;
	
	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}		
		if(o == null) return false;
		if(getClass() != this.getClass()) return false;
		Person other = (Person) o;
		if(this.age != other.age) {
			return false;
		}
		if(this.name == null) {
			if(other.name != null) {
				return false;
			}
		} else {
			return name.equals(other.name);
		}
		return false;
	}
}
