package org.java.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {
	
	private int total = 0;
	private int count = 0;

	public static void main(String args[]) {
		List<Person> set = new ArrayList<>();
		JavaStream i = new JavaStream();
		set.add(i.createPerson("Pankaj", 24, "male"));
		set.add(i.createPerson("Nupur", 25, "female"));
		set.add(i.createPerson("Vishal", 25, "male"));
		set.add(i.createPerson("Rohit", 25, "male"));
		set.add(i.createPerson("Snehika", 24, "female"));
		set.add(i.createPerson("Suruchi", 23, "female"));
		
		System.out.println(set);
		
		System.out.println("Male avg age - "+set.stream().filter(p -> p.getGender() == "male").mapToInt(Person::getAge).average().getAsDouble());
		
		System.out.println("Age sum - "+set.stream().mapToInt(Person::getAge).sum());
		
		System.out.println("Age sum reduce - "+set.stream().map(Person::getAge).reduce(0, (a, b) -> a+b));
		
		JavaStream ic = set.stream().filter(p -> p.getGender().equals("male")).map(Person::getAge).collect(JavaStream::new, JavaStream::accept, JavaStream::combine);
		
		System.out.println("Male avg age - "+ic.average());
		
		System.out.println("Names - "+set.stream().map(p -> p.getName()).collect(Collectors.toList()));
		
		System.out.println("Grouping - "+set.stream().collect(Collectors.groupingBy(Person::getGender)));
		
		System.out.println("Grouping 2 - "+set.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList()))));
		
		System.out.println("Avg age by gender - "+set.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.averagingInt(Person::getAge))));
	}
	
	public double average() {
		return count > 0 ? ((double) total)/count : 0;
	}
	
	public void accept(int i) {
		total += i;
		count++;
	}
	
	public void combine(JavaStream other) {
		total += other.total;
		count += other.count;
	}
	
	private Person createPerson(String name, int age, String gender) {
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		p.setGender(gender);
		return p;
	}
}

class Person{
	private String name;
	private int age;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return "name: "+name+", age: "+age+", gender: "+gender;
	}
}