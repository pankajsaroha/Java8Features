package org.java.collection;

public class Mapentry {

	private Object key;
	private Object value;
	
	Mapentry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public Object getKey() {
		return key;
	}
	
	public Object getValue() {
		return value;
	}
	
	public int compareTo(Object obj) {
		Object key2 = ((Mapentry) obj).getKey();
		return ((Mapentry) key).compareTo(key2);
		
	}
}
