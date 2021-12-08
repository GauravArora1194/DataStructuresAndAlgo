package com.interview.flipkart;

/**
 * https://leetcode.com/problems/gas-station/
 * 
 * @author gauravarora02
 *
 */
public class GasStationProblem {

	public static void main(String[] args) {

		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };

		canCompleteCircuit(gas, cost);
	}

	// Gives TLE, complexity - O(n * n)
	public static int canCompleteCircuit(int[] gas, int[] cost) {

		for (int i = 0; i < gas.length; i++) {

			int balance = 0;
			int j = i;
			int count = 0;

			for (; j < gas.length;) {

				balance += gas[j] - cost[j];

				if (balance < 0 || count == gas.length) {
					break;
				}

				count++;

				j = (j + 1) % gas.length;

			}

			if (count == gas.length) {
				return i;
			}
		}

		return -1;

	}

	// complexity - O(n)
	public static int canCompleteCircuitOptimized1(int[] gas, int[] cost) {

		int totalGasInCar = 0;

		for (int i = 0; i < gas.length; i++) {

			totalGasInCar += gas[i] - cost[i];
		}

		if (totalGasInCar < 0) {
			return -1;
		}

		totalGasInCar = 0;
		int start = 0;

		for (int i = 0; i < gas.length; i++) {

			totalGasInCar += gas[i] - cost[i];

			if (totalGasInCar < 0) {

				start = i + 1;
				totalGasInCar = 0;
			}

		}

		return start;

	}

	public static int canCompleteCircuit2(int[] gas, int[] cost) {

		int total = 0;
		int gasInTank = 0;
		int start = 0;

		for (int i = 0; i < gas.length; i++) {

			gasInTank += gas[i] - cost[i];

			if (gasInTank < 0) {

				start = i + 1;
				total += gasInTank;
				gasInTank = 0;
			}

		}

		return (total + gasInTank) < 0 ? -1 : start;
	}
}
