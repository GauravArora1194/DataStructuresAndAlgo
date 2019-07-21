package com.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	// Using sieve of eratosthenes method

	public static List<Integer> getPrimeNumbers(int n) {

		boolean[] arr = new boolean[n + 1];

		List<Integer> list = new ArrayList<>();

		for (int i = 2; i * i <= n; i++) {

			if (!arr[i]) {

				for (int j = 2 * i; j <= n; j = j + i) {

					arr[j] = true;
				}

			}

		}

		for (int i = 2; i <= n; i++) {

			if (!arr[i]) {

				list.add(i);
			}
		}

		return list;
	}

	public static boolean checkIfNumberIsPrime(int number) {

		int count = 2;

		while (count * count <= number) {

			if (number % count == 0) {

				return false;
			}

			count++;
		}

		return true;

	}

	public static void main(String[] args) {

		List<Integer> list = getPrimeNumbers(50);

		for (int i : list) {
			System.out.print(i + " ");
		}

		System.out.println();

		System.out.println(list.size());

		// boolean isPrime = checkIfNumberIsPrime(53);

		// System.out.println(isPrime);
	}

}
