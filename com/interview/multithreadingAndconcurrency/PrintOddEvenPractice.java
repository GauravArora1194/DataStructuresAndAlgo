package com.interview.multithreadingAndconcurrency;

import java.util.concurrent.TimeUnit;

public class PrintOddEvenPractice {

	public static void main(String[] args) {

		Print printer = new Print();

		Thread t1 = new Thread(new PrintOddAndEvenTask(10, printer, false));
		Thread t2 = new Thread(new PrintOddAndEvenTask(10, printer, true));

		t1.start();
		t2.start();

	}

}

class Print {

	boolean isOddPrinted = false;

	public synchronized void printEven(int number) {

		if (isOddPrinted == false) {

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

		isOddPrinted = false;
		notify();
	}

	public synchronized void printOdd(int number) {

		if (isOddPrinted == true) {

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

		isOddPrinted = true;
		notify();
	}
}

class PrintOddAndEvenTask implements Runnable {

	private int max;
	private Print printer;
	private boolean isEven;

	public PrintOddAndEvenTask(int max, Print printer, boolean isEven) {
		super();
		this.max = max;
		this.printer = printer;
		this.isEven = isEven;
	}

	@Override
	public void run() {

		int number = isEven ? 2 : 1;

		while (number <= max) {

			if (isEven)
				printer.printEven(number);
			else
				printer.printOdd(number);

			number = number + 2;
		}

	}

}