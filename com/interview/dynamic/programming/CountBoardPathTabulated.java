package com.interview.dynamic.programming;

public class CountBoardPathTabulated {

	// find count from source to destination

	public static void main(String[] args) {

		int destination = 30;

		long startTime = System.currentTimeMillis();
		int count = countPathTabulated(destination);
		System.out.println(count);
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken : " + (endTime - startTime));
	}

	private static int countPathTabulated(int destination) {

		int[] arr = new int[destination + 1];

		arr[destination] = 1;

		for (int x = destination - 1; x >= 0; x--) {

			for (int dice = 1; dice <= 6; dice++) {

				if (x + dice <= destination) {

					arr[x] = arr[x] + arr[x + dice];
				}

			}
		}

		return arr[0];

	}

}
