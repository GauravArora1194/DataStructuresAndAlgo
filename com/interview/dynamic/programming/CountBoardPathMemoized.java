package com.interview.dynamic.programming;

public class CountBoardPathMemoized {

	public static int countBoardPath(int s, int d) {

		if (s > d) {
			return 0;
		}

		if (s == d) {
			return 1;
		}

		int cstod = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int i = s + dice;
			int citod = countBoardPath(i, d);
			cstod = cstod + citod;

		}

		return cstod;
	}

	public static int CountPathMemoized(int s, int d, int[] memoizedArr) {

		if (s > d) {
			return 0;
		}

		if (s == d) {
			return 1;
		}

		if (memoizedArr[s] != 0) {
			return memoizedArr[s];
		}

		int cstod = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int i = s + dice;
			int citod = CountPathMemoized(i, d, memoizedArr);
			cstod = cstod + citod;

		}

		memoizedArr[s] = cstod;
		return cstod;
	}

	public static void main(String[] args) {

		int n = 30;
		long startTime = System.currentTimeMillis();
		System.out.println(countBoardPath(0, n));
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken : " + (endTime - startTime));

		long startTime1 = System.currentTimeMillis();
		System.out.println(CountPathMemoized(0, n, new int[n + 1]));
		long endTime1 = System.currentTimeMillis();
		System.out.println("Time Taken : " + (endTime1 - startTime1));
	}
}
