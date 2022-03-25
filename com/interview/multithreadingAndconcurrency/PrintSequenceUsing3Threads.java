package com.interview.multithreadingAndconcurrency;

public class PrintSequenceUsing3Threads {

	public static void main(String[] args) {

		Thread t1 = new Thread(new SeqTask(1));
		Thread t2 = new Thread(new SeqTask(2));
		Thread t3 = new Thread(new SeqTask(0));

		t1.start();
		t2.start();
		t3.start();
	}
}

class SeqTask implements Runnable {

	private static int number = 1;
	private static final int MAX_VALUE = 10;
	private int remainder;

	private static Object lock = new Object();

	public SeqTask(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {

		while (number < MAX_VALUE - 1) {

			synchronized (lock) {

				while (number % 3 != remainder) {

					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println(number);
				number++;
				lock.notifyAll();

			}
		}

	}

}
