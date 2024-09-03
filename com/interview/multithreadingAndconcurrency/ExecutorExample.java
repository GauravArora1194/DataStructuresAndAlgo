package com.interview.multithreadingAndconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

	
	public static void main(String[] args) {
		
		Task t1 = new Task();
		Task t2 = new Task();
		Task t3 = new Task();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ExecutorService executor1 = Executors.newCachedThreadPool();
		ExecutorService executor2 = Executors.newSingleThreadExecutor();
		
		executor.submit(t1);
		executor.submit(t2);
		executor.submit(t3);
		
		// System.out.println(executor.isTerminated());
		executor.shutdown();
		
		
		// System.out.println(executor.isTerminated());
		// System.out.println(executor.isShutdown());
		
	}
	
	
}


class Task implements Runnable{
	

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}