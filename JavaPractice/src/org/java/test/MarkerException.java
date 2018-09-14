package org.java.test;

public class MarkerException extends Exception implements SuperMarkerInterface{

	public MarkerException() {
		//System.out.println("Marker Not Supported");
	}

	@Override
	public void display() throws MarkerException {
		System.out.println("Displaying....");
		
	}
	
	/*public void display() throws MarkerException{
		System.out.println("Displaying....");
	}*/
}
