package org.java.test;

public class HitachiMcq {

	public static void main(String args[]) {
		HitachiMcq h = new HitachiMcq();
		h.start();
	}
	
	void start() {
		String s1 = "hack";
		String s2 = val(s1);
		System.out.println(s1+ " " +s2);
	}
	
	String val(String s1) {
		s1 = s1+"earth";
		System.out.println(s1+" ");
		return "hackathons";
	}
}
