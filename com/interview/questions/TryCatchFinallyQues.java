package com.interview.questions;

class ABC {

	/*
	 * private String getName() { return "Hello"; }
	 */
}

public class TryCatchFinallyQues {

	// @SuppressWarnings("finally")
	@SuppressWarnings("finally")
	public static int checkTryCatchFinally() {

		int i = 2;
		try {

			return i;
		} catch (Exception e) {
			return 2;
		} finally {
			return i = 5;
		}

	}

	public static void main(String[] args) {

		ABC a = new ABC();
		a.getClass();

		System.out.println(checkTryCatchFinally());

		int[] arr = new int[10];

		arr.getClass().getName();
	}
}
