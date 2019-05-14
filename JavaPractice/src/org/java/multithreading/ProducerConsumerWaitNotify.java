package org.java.multithreading;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable{
	private final List<Integer> task;
	private final int max;
	
	public Producer(List<Integer> task, int max) {
		this.task = task;
		this.max = max;
	}
	
	@Override
	public void run() {
		int counter = 0;
		while(true) {
			try {
				produce(counter++);
			} catch(Exception e) {
				System.out.println("Produce err "+ e);
			}
		}
	}
	
	public void produce(int i) throws InterruptedException {
		synchronized (task) {
			Thread name = new Thread();
			if(max == task.size()) {
				name = Thread.currentThread();
				System.out.println("Producer full. "+Thread.currentThread().getName()+" waits (producer)");
				task.wait();
			}
			Thread.sleep(5000);
			task.add(i);
			System.out.println(Thread.currentThread().getName()+" calls notify (producer).");
			task.notify();
			System.out.println("Checking producer me waiting wala thread jaga ki nhi "+name+" - "+name.isAlive());
		}
	}
}

class Consumer implements Runnable{
	private List<Integer> taskConsume;
	
	public Consumer(List<Integer> taskConsume) {
		this.taskConsume = taskConsume;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				consume();
			} catch(Exception e) {
				System.out.println("Consumer err "+e);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		Thread name = new Thread();
		if(taskConsume.isEmpty()) {
			name = Thread.currentThread();
			System.out.println("Consumer Khali. "+Thread.currentThread().getName()+" waits (consumer)");
			taskConsume.wait();
		}
		Thread.sleep(5000);
		taskConsume.remove(0);
		System.out.println(Thread.currentThread().getName()+" calls notify (consumer).");
		taskConsume.notify();
		System.out.println("Checking consumer me waiting wala thread jaga ki "+name+" - "+name.isAlive());
	}
}

public class ProducerConsumerWaitNotify {

	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		int max = 5;
		Thread tp = new Thread(new Producer(list, max), "Producer");
		Thread tc = new Thread(new Consumer(list), "Consumer");
		tp.start();
		tc.start();
	}
}
