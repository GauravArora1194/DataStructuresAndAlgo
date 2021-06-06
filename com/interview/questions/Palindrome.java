package com.interview.questions;

public class Palindrome {

	public static boolean checkIfPalindrome(int num) {

		int temp = reverse(num);
		if (temp == num)
			return true;

		return false;
	}

	public static int reverse(int num) {

		int reverseNum = 0;
		while (num != 0) {

			reverseNum = reverseNum * 10 + num % 10;
			num = num / 10;
		}

		return reverseNum;
	}

	public static boolean checkPalindromeByComparison(int num) {

		int divisor = 1;

		while (num / divisor >= 10) {
			divisor *= 10;
		}

		while (num != 0) {
			int leadDigit = num / divisor;
			int lastDigit = num % 10;

			if (leadDigit != lastDigit)
				return false;

			num = (num % divisor) / 10;
			divisor /= 100;
		}

		return true;
	}

	// replace every occurrence of 0 with 5
	public static int replace0With5(int num) {

		if (num == 0)
			return 0;

		int lastDigit = num % 10;

		if (lastDigit == 0)
			lastDigit = 5;

		return replace0With5(num / 10) * 10 + lastDigit;
	}

	public static int reversecheck(int x) {

		if (Integer.MIN_VALUE <= x && x <= Integer.MAX_VALUE) {

			long reverse = 0;
			boolean isNegative = false;

			if (x < 0) {
				isNegative = true;
				x *= -1;
			}

			while (x != 0) {

				reverse = reverse * 10L + x % 10;
				x = x / 10;
				
				if(Integer.MIN_VALUE > reverse && reverse > Integer.MAX_VALUE) {
					return 0;
				}
			}

			if (Integer.MIN_VALUE <= reverse && reverse <= Integer.MAX_VALUE) {

				if (isNegative) {
					return (int) (reverse * -1L);
				} else {
					return (int) reverse;
				}

			} else {

				return 0;
			}

		} else
			return 0;

	}

	public static void main(String[] args) {

		System.out.println(checkPalindromeByComparison(12321));

		System.out.println("New number : " + replace0With5(1020));

		System.out.println(reversecheck(1534236469));

	}
}
