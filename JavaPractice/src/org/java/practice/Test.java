package org.java.practice;

abstract class Foo {

	protected final int var;
	
	int n = 5;
	
	Foo() {
		var = 10;
	}
	
	Foo(int x) {
		var = x;
	}
	
	abstract void solve();
	
	void print() {
		System.out.println(var);
	}
	
	static void display() {
		System.out.println("display");
	}
}

interface Bar {
	int a = 10;
	
	void print();
	
	default void defaultMethod() {
		System.out.println("Interface default");
	}
	
	static void display() {
		System.out.println("Interface Bar display");
	}
}

class FooImpl extends Foo{

	
	FooImpl(int x) {
		super(x);
	}
	@Override
	void solve() {
		System.out.println(var);
		System.out.println(n);
	}
	
}

class BarImpl implements Bar {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(a);
	}
	
}

public class Test {
	public static void main(String args[]) {
		Foo foo = new FooImpl(20);
		Foo f = new FooImpl(21);
		foo.n = 15;
		f.n = 16;
		foo.solve();
		Foo.display();
		f.solve();
		
		Bar bar = new BarImpl();
		Bar b = new BarImpl();
		bar.print();
		b.print();
		Bar.display();
		b.defaultMethod();
		bar.defaultMethod();
	}
}
