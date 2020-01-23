package org.java.multithreading;

public class ThreadSignal {

    static ThreadSignal ts1 = new ThreadSignal();
    static ThreadSignal ts2 = new ThreadSignal();

    public static void main(String[] args) {
        ts1.method1();
    }

    public void method1() {
        synchronized (ts1) {
            try {
                ts2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Just checking...");
    }
}