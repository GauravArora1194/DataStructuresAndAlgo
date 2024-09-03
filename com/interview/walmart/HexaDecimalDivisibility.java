package com.interview.walmart;

/**
 * Given a string S consisting of a large hexadecimal number, the task is to
 * check its divisibility by a given decimal number M. If divisible then print
 * Yes else print No.
 * 
 * @author gauravarora02
 *
 */
public class HexaDecimalDivisibility {

	public static void main(String[] args) {

		String hexa = "10";
		int decimal = 3;

		int remainder = 0;

		for (int i = 0; i < hexa.length(); i++) {

			char c = hexa.charAt(i);

			if (c >= '0' && c <= '9') {
				remainder = (remainder * 16 + c - '0') % decimal;
			} else {
				remainder = (remainder * 16 + c - 'A') % decimal;
			}
		}

		System.out.println(remainder);
	}
}
