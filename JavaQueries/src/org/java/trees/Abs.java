package org.java.trees;

abstract class A {
	
	private void method1() {
		System.out.println(this + "Private method " + Thread.currentThread().getName());
	}
	
	public void method2() {
		method1();
		System.out.println(this + "Public method " + Thread.currentThread().getName());
	}
}

public class Abs extends A{

	public static void main(String[] args) {
		Abs ab = new Abs();
		ab.method2();
	}
}
