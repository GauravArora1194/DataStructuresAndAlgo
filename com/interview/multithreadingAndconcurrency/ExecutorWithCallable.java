package com.interview.multithreadingAndconcurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorWithCallable {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		long start  = System.currentTimeMillis();
		
		Future<Integer> task1 = executor.submit(new CallableTask());
		
		Future<Integer> task2 = executor.submit(new CallableTask());
		
		executor.shutdown();
		
		while(!executor.isTerminated()) {
			
			//System.out.println("Waiting for the task to complete!");
		}
	
		long end = System.currentTimeMillis();
		System.out.println("Task1 returned : " + (Integer) task1.get());
		
		System.out.println("Task1 returned : " + (Integer) task2.get());
		
		System.out.println("Task Completed in " + (end - start)/1000 + " Seconds ");
	}

}


class CallableTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		// Thread.sleep(2000);
		
		// Causes the thread to sleep for 2 seconds
		// This approach is better than Thread.sleep(millis)
		TimeUnit.SECONDS.sleep(2);
		
		return new Random().nextInt();
	}
	
}