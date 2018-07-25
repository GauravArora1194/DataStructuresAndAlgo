package com.interview.questions;

import java.util.Scanner;

/*
 *  converts binary number into decimal number
 */
public class BinaryToDecimal {

	public static void main(String[] args) {

		
		System.out.println(5.0%2);
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int decimal = 0;
		int bit;
		int n = 0;
		while (num != 0) {
			bit = num % 10;
			decimal += (Math.pow(2, n) * bit);
			num = num / 10;
			n++;
		}
		sc.close();
		System.out.println(decimal);

	}

}
