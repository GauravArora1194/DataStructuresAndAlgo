package com.interview.questions;

public class ReverseNumber {

	public static int reverseNumber(int number) {

		int reverseNumber = 0;

		while (number != 0) {

			reverseNumber = (reverseNumber * 10) + number % 10;
			number /= 10;

		}

		return reverseNumber;

	}

	public static void main(String[] args) {

		int number = 12345;

		System.out.println(number);
		System.out.println(reverseNumber(number));
	}
}
