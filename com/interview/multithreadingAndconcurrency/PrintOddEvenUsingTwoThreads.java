package com.interview.multithreadingAndconcurrency;

import java.util.concurrent.TimeUnit;

public class PrintOddEvenUsingTwoThreads {
	
	public static void main(String[] args) {
		
		NumberPrinter printer = new NumberPrinter();

		Thread odd = new Thread(new PrintOddEvenTask(10, printer, false));
		Thread even = new Thread(new PrintOddEvenTask(10, printer, true));
		
		odd.start();
		even.start();
	}
	
}

class NumberPrinter{
	
	private boolean isOdd = false;
	
	public synchronized void printOdd(int number) {
		
		while(isOdd) {
			
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
	
	public synchronized void printEven(int number) {
		
		while(!isOdd) {
			
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
	
}


class PrintOddEvenTask implements Runnable{

	private int max;
	private boolean isEvenNumber;
	private NumberPrinter printer;
	
	
	public PrintOddEvenTask(int max, NumberPrinter printer, boolean isEvenNumber) {
		this.max = max;
		this.isEvenNumber = isEvenNumber;
		this.printer = printer;
	}
	
	
	@Override
	public void run() {
		
		int number = isEvenNumber == true ? 2 : 1;
		
		while(number <= max) {
			
			if(isEvenNumber)
				printer.printEven(number);
			else
				printer.printOdd(number);
			
			number = number + 2;
		}
		
	}
	
}
