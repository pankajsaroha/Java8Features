package org.java.design.patterns;

/* Structural Design Pattern */

public class Adaptor {
    
    public static void main(String[] args) {
        testClassAdaptor();
        testObjectAdaptor();
    }

    public static void testClassAdaptor() {
        SocketAdaptor socketAdaptor = new SocketClassAdaptorImpl();
        Volt v3 = getVolts(socketAdaptor, 3);
        Volt v24 = getVolts(socketAdaptor, 24);
        Volt v240 = getVolts(socketAdaptor, 240);

        System.out.println("V3 volts using class adaptor : " + v3.getVolts());
        System.out.println("V24 volts using class adaptor : " + v24.getVolts());
        System.out.println("V240 volts using class adaptor : " + v240.getVolts());
    }

    public static void testObjectAdaptor() {
        SocketAdaptor socketAdaptor = new SocketClassAdaptorImpl();
        Volt v3 = getVolts(socketAdaptor, 3);
        Volt v24 = getVolts(socketAdaptor, 24);
        Volt v240 = getVolts(socketAdaptor, 240);

        System.out.println("V3 volts using object adaptor : " + v3.getVolts());
        System.out.println("V24 volts using object adaptor : " + v24.getVolts());
        System.out.println("V240 volts using object adaptor : " + v240.getVolts());
    }

    public static Volt getVolts(SocketAdaptor socketAdaptor, int i) {
        switch(i) {
            case 3 : return socketAdaptor.get3Volts();
            case 24 : return socketAdaptor.get24Volts();
            case 240 : return socketAdaptor.get240Volts();
            default : return socketAdaptor.get240Volts();
        }
    }
}

class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }

}

class Socket {
    public Volt getVolts() {
        return new Volt(240);
    }       
}

interface SocketAdaptor {
    public Volt get240Volts();
    public Volt get24Volts();
    public Volt get3Volts();
}

/* 
    Class Pattern - uses java inheritance
    Object Pattern - uses java composition
*/

class SocketClassAdaptorImpl extends Socket implements SocketAdaptor {

    @Override
    public Volt get240Volts() {
        return getVolts();
    }

    @Override
    public Volt get24Volts() {
        Volt volt = getVolts();
        return convertVolt(volt, 10);
    }

    @Override
    public Volt get3Volts() {
        Volt volt = getVolts();
        return convertVolt(volt, 80);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }

}

class SocketObjectAdaptorImpl implements SocketAdaptor {

    Socket socket = new Socket();

    @Override
    public Volt get240Volts() {
        return socket.getVolts();
    }

    @Override
    public Volt get24Volts() {
        Volt volt = socket.getVolts();
        return convertVolt(volt, 10);
    }

    @Override
    public Volt get3Volts() {
        Volt volt = socket.getVolts();
        return convertVolt(volt, 80);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }
}