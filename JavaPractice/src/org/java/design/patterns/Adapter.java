package org.java.design.patterns;

class Volt {
	public int volt;
	
	public Volt(int volt) {
		this.volt = volt;
	}

	public int getVolt() {
		return volt;
	}

	public void setVolt(int volt) {
		this.volt = volt;
	}
}

class Socket {
	
	public Volt getVolt() {
		return new Volt(120);
	}
}

interface SocketAdapter {
	public Volt get120Volt();
	public Volt get12Volt();
	public Volt get3Volt();
}

//Class Adaptor

class SocketAdapterClassImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get120Volt() {
		return getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt v = getVolt();
		return convertVolt(v, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt v = getVolt();
		return convertVolt(v, 40);
	}
	
	public Volt convertVolt(Volt v, int n) {
		return new Volt(v.getVolt()/n);
	}
}

class SocketAdapterObjectImpl implements SocketAdapter {
	
	Socket socket = new Socket();

	@Override
	public Volt get120Volt() {
		Volt v = socket.getVolt();
		return v;
	}

	@Override
	public Volt get12Volt() {
		Volt v = socket.getVolt();
		return convertVolt(v, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt v = socket.getVolt();
		return convertVolt(v, 40);
	}
	
	public Volt convertVolt(Volt v, int n) {
		return new Volt(v.getVolt()/n);
	}
}

/*public class AdaptorStructural {
	
	public static void main(String args) {
		testClassAdapter();
		testObjectAdapter();
	}
}*/


public class Adapter {

	public static void main(String args[]) {
		testClassAdapter();
		testObjectAdapter();
	}
	

	
	public static void testClassAdapter() {
		SocketAdapter adapter = new SocketAdapterClassImpl();
		Volt v120 = adapter.get120Volt();
		Volt v12 = adapter.get12Volt();
		Volt v3 = adapter.get3Volt();
		
		System.out.println("V3 class adapter "+v3.getVolt());
		System.out.println("V12 class adapter "+v12.getVolt());
		System.out.println("v120 class adapter "+v120.getVolt());
	}
	
	public static void testObjectAdapter() {
		SocketAdapter adapter = new SocketAdapterObjectImpl();
		Volt v120 = adapter.get120Volt();
		Volt v12 = adapter.get12Volt();
		Volt v3 = adapter.get3Volt();
		
		System.out.println("V3 object adapter "+v3.getVolt());
		System.out.println("V12 object adapter "+v12.getVolt());
		System.out.println("v120 object adapter "+v120.getVolt());
	}
}
