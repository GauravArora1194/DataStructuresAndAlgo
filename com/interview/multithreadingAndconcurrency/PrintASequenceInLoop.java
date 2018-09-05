package com.interview.multithreadingAndconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrintASequenceInLoop {

	
	// Given n threads, where thread 1 prints 1, Thread 2 prints 2, Thread 3 prints 3 and so on...
	// The task is to print a sequence like - 1234...n 1234...n 1234...
	
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Task1 task1 = new Task1();
		Task2 task2 = new Task2();
		Task3 task3 = new Task3();
		
		for(int i = 1; i <= 10; i++) {
			
			executor.execute(task1);
			executor.execute(task2);
			executor.execute(task3);
		}
		
		executor.shutdown();
		
		//System.out.println(executor.isTerminated());
		
	}
	
	
	
}

class Task1 implements Runnable{

	@Override
	public void run() {
		
		System.out.print(1);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

class Task2 implements Runnable{

	@Override
	public void run() {
		
		System.out.print(2);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
class Task3 implements Runnable{

	@Override
	public void run() {
		
		System.out.print(3);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
