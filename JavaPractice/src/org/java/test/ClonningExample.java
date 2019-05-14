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
		
		System.out.println(c1.name);
		System.out.println(c2.name);
		
		//c2.name = "Pankaj Saroha";
		
		System.out.println(c1.equals(c2));
		System.out.println(c2.hashCode());
	}
	
	/*public boolean equals(ClonningExample c2) {
		return this.name.equals(c2.name);
	}*/
}
