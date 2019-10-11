package org.java.test;

public class ClonningExample implements Cloneable{

	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	String name="Pankaj Kumar";
	
	public static void main(String args[]) throws CloneNotSupportedException {
		ClonningExample c1 = new ClonningExample();
		ClonningExample c2 = (ClonningExample) c1.clone();
		
		System.out.println(c2.name);
	}
}
