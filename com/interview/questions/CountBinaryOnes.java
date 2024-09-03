package com.interview.questions;

import java.util.Scanner;

public class CountBinaryOnes {

	/*
	 * By- Brian Kernighan’s Algorithm:
	 * 
	 * 1 Initialize count: = 0 
	 * 2 If integer n is not zero 
	 * 		(a) Do bitwise & with(n-1) and assign the value back to n n: = n&(n-1) 
	 * 		(b) Increment count by 1
	 * 		(c) go to step 2 
	 * 3 Else return count
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = sc.nextInt();
		int count = 0;

		while (num != 0) {
			num = num & (num - 1);
			count++;

		}
		sc.close();
		System.out.println(count);

	}

}
