package com.interview.multithreadingAndconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrintASequenceInLoop {

	// Given n threads, where thread 1 prints 1, Thread 2 prints 2, Thread 3 prints
	// 3 and so on...
	// The task is to print a sequence like - 1234...n 1234...n 1234...

	public static void main(String[] args) {

		ExecutorService executor = Executors.newSingleThreadExecutor();

		PrintTask task1 = new PrintTask(1);
		PrintTask task2 = new PrintTask(2);
		PrintTask task3 = new PrintTask(3);

		for (int i = 1; i <= 10; i++) {

			executor.execute(task1);
			executor.execute(task2);
			executor.execute(task3);
		}

		executor.shutdown();

		// System.out.println(executor.isTerminated());

	}

}

class PrintTask implements Runnable {

	private int number;

	public PrintTask(int number) {
		this.number = number;
	}

	@Override
	public void run() {

		System.out.print(number);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
