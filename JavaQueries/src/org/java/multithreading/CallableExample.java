package org.java.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableExample implements Callable{

	public Object call() throws InterruptedException {
		Random random = new Random();
		Integer randomNumber = random.nextInt(5);
		Thread.sleep(randomNumber * 1000);
		return randomNumber;
	}
}
