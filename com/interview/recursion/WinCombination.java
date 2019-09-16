package com.interview.recursion;

public class WinCombination {

	static int totalRound = 4;

	public static void main(String[] args) {

		int round = 10;
		int point = 3;

		// prints all the possible combination for given Round(r) and Point(p)

		long startTime = System.currentTimeMillis();
		long total = printCombination(round, point);

		long endTime = System.currentTimeMillis();

		System.out.println(total);

		System.out.println("Time Taken : " + (endTime - startTime) / 1000);
	}

	private static long printCombination1(int round, int point) {

		int minDistance = point;
		long totalCombination = 1;

		for (int win = minDistance; win <= round; win++) {

			for (int loss = 1; (loss * point + loss) <= round; loss++) {

				int winNeeded = loss * point;
				int currentWin = win;

				int remainingWin = 0;

				if (currentWin < winNeeded) {
					remainingWin = winNeeded - currentWin;
				}

				if (win + loss <= round) {

					if (loss == 1) {
						totalCombination += 1;
					} else if (remainingWin > 0) {

						int remaining = round - (loss * point + loss);
						totalCombination = totalCombination + remaining + 1;
					} else {

						int remaining = round - (loss * point + loss);
						totalCombination = totalCombination + remaining;
					}
				}

			}

		}

		return totalCombination;

	}

	private static long printCombination(int round, int point) {

		long totalCombination = 1;
		int distance;

		for (int loss = 1; (loss * point) < round; loss++) {

			distance = loss * point;
			if (loss < (round - distance)) {

				totalCombination = totalCombination + findCombination(round, point, loss, distance);
			}
		}

		return totalCombination;

	}

	private static long findCombination(int round, int point, int loss, int distance) {

		// long p = factorial(round - distance);
		// long c = factorial(loss);
		// long r = factorial(round - distance - loss);

		// long total = (p) / (c * r);

		long total = binomialCoeffOptimized((round - point), loss);

		return total;
	}

	private static long factorial(int i) {

		if (i == 0)
			return 1;

		long fact = i * factorial(i - 1);

		return fact % (1000000007);
	}

	static long binomialCoeff(int n, int k) {

		// Base Cases
		if (k == 0 || k == n)
			return 1;

		// Recur
		return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
	}

	static long binomialCoeffOptimized(int n, int k) {
		long res = 1;

		// Since C(n, k) = C(n, n-k)
		if (k > n - k)
			k = n - k;

		// Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}
}
