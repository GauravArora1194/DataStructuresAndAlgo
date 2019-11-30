package com.interview.makemytrip;

/**
 * 
 * Find the number of values divisible by K between A and B
 * 
 * @author gauravarora02
 *
 */
public class Problem {

	public int getCount(int a, int b, int k) {

		int count = 0;

		if (a % k == 0)
			count++;

		if (b % k == 0)
			count++;

		count = count + (b - a) / k;

		return count;

	}

	public static void main(String[] args) {

		Problem p = new Problem();

		System.out.println(p.getCount(6, 11, 2));
	}

}
