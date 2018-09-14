package org.java.test;
public class Test1 extends MarkerException implements MarkerInterface{
	
	@Override
	public void display() throws MarkerException{
		super.display();
	}
	
	public static void main(String args[]) throws MarkerException {
		Test1 t= new Test1();
		if((t instanceof MarkerInterface)) {
			t.display();
		}else {
			throw new MarkerException();
		}
	}
	/*
	public void display() {
		System.out.println("Displaying....");
	}*/
}