package org.java.generics;

public class BoxTest<T, S> {

	private T t;
	private S s;
	
	public BoxTest(T t, S s) {
		this.t = t;
		this.s = s;
	}

	public T getT() {
		return t;
	}
	
	public S getS() {
		return s;
	}

	/*public void setT(T t) {
		this.t = t;
	}*/
	
	
}
