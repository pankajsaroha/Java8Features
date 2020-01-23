package org.java.practice;

abstract class Abs {
	private int x;
	private int y;
	
	Abs(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void foo() {
		System.out.println(x+y);
        bar();
   }

   private void bar() {
        doSomething();
   }

   protected abstract void doSomething();
}

public class Interview extends Abs{

	Interview(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Interview i = new Interview(5, 5);
		i.foo();		
	}

	@Override
	protected void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("Something");
	}
}
