package org.java.test;

public class Node implements Cloneable{

	int value;
	Node next;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
