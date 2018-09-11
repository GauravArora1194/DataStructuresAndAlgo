package com.interview.multithreadingAndconcurrency;

import java.util.concurrent.TimeUnit;

public class VolatileInJava {
	
	private static volatile int myInt = 0;
	
	public static void main(String[] args) {
		
		new ChangeListener().start();
		new ChangeMaker().start();
		
	}
	
	static class ChangeListener extends Thread {
		
		@Override
		public void run() {
			
			int localValue = myInt;
			System.out.println(Thread.currentThread().getName() + " localValue : " + localValue);
			while(localValue < 5) {
				
				if (localValue != myInt) {
					System.out.println("myInt changed to " + myInt);
					localValue = myInt;
				}
			}
		}
	}
	
	
	static class ChangeMaker extends Thread {
		
		@Override
		public void run() {
			
			int localValue = myInt;
			System.out.println(Thread.currentThread().getName() + " localValue : " + localValue);
			while(myInt < 5) {
				System.out.println("Incrementing myInt to " + (localValue + 1));
				myInt = ++localValue;
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
