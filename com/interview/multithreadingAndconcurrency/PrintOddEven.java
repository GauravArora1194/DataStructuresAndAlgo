package com.interview.multithreadingAndconcurrency;

import java.util.concurrent.TimeUnit;

public class PrintOddEven {

	// Print numbers in sequence using 2 Threads, where Thread 1 prints only odd
	// values and
	// Thread 2 prints only even values.

	public static void main(String[] args) {

		Printer printer = new Printer();

		Thread t1 = new Thread(new TaskOddEven(10, printer, false));
		Thread t2 = new Thread(new TaskOddEven(10, printer, true));

		t1.start();
		t2.start();
		// t1.start(); (calling t1 after t2 will give the same result)
	}
}

class Printer {

	boolean isOdd = false;

	synchronized void printEven(int number) {

		while (isOdd == false) {

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Even : " + number);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isOdd = false;
		notify();
	}

	synchronized void printOdd(int number) {

		while (isOdd == true) {

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Odd : " + number);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isOdd = true;
		notify();
	}
}

class TaskOddEven implements Runnable {

	private int max;
	private Printer printer;
	private boolean isEvenNumber;

	public TaskOddEven(int max, Printer printer, boolean isEvenNumber) {
		super();
		this.max = max;
		this.printer = printer;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
	public void run() {

		int number = isEvenNumber == true ? 2 : 1;

		while (number <= max) {

			if (isEvenNumber)
				printer.printEven(number);
			else
				printer.printOdd(number);

			number = number + 2;
		}

	}

}