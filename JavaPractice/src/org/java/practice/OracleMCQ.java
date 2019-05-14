package org.java.practice;

class Test1 {
	public Test1 () {
		System.out.println("Test1");
	}
	public Test1(int i) {
		this();
		System.out.println(i);
	}
}

class Test2 extends Test1{
	public Test2 () {
		System.out.println("Test2");
	}
	public Test2(int i) {
		this();
		System.out.println(i+3);
	}
}

public class OracleMCQ {
	public static void main(String args[]) {
		new Test2(5);
	}
}

class Test01{

    public static void main(String []args){
        Object obj = new Float(1.5);
        String[] names = new String[100];
        Float floatobj = new Float(3.2f);
        obj = names;
        floatobj = (Float) obj;	//actual ques line - floatobj = obj;
        System.out.println("H");
    }
}