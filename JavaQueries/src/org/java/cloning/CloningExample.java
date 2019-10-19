package org.java.cloning;

public class CloningExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        City city = new City("Dehradun");
        Person person1 = new Person("Nupur", 10000, city);
        System.out.println(person1);
		
		Person person2 = person1.clone();
		System.out.println(person2);
		
		if(person1 == person2) {
			System.out.println("Both person1 and person2 hold the same object");
		}
		
		if(person1.equals(person2)) {
			System.out.println("Both person1 and person2 are equal and have same content");
		}
		
		if(person1.getCity() == person2.getCity()) {
			System.out.println("Both person1 and person2 have same city object");
		}
    }
}