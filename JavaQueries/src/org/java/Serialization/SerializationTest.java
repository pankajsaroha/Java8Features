package org.java.Serialization;

import java.io.IOException;

public class SerializationTest {

	public static void main(String args[]) {
		String fileName = "employee.ser";
		Employee emp = new Employee();
		emp.setId(10);
		emp.setName("Pankaj");
		emp.setSalary(99999);
		
		try {
			SerializationUtil.serialize(emp, fileName);
		}catch(IOException e) {
			e.printStackTrace();
			return;
		}
		
		Employee empNew = null;
		try {
			empNew = (Employee) SerializationUtil.deserialize(fileName);
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("emp Object :"+emp);
		System.out.println("empNew Object :"+empNew);
	}
}
