package com.interview.dynamic.programming;

/**
 * This problem is similar to word wrap.
 * 
 * @author gauravarora02
 *
 */
public class TextJustification {

	public static void main(String[] args) {

		String words[] = { "Gaurav", "likes", "to", "write", "code", "at", "free", "time" };
		getSpaces(words, 10);
		System.out.println();
		getSpacesOptimized(words, 10);
	}

	// Not working
	public static void getSpaces(String[] words, int width) {

		int cost[][] = new int[words.length][words.length];

		// next 2 for loop is used to calculate cost of putting words from
		// i to j in one line. If words don't fit in one line then we put
		// Integer.MAX_VALUE there.
		for (int i = 0; i < words.length; i++) {
			cost[i][i] = width - words[i].length();
			for (int j = i + 1; j < words.length; j++) {
				cost[i][j] = cost[i][j - 1] - words[j].length() - 1;
			}
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i; j < words.length; j++) {
				if (cost[i][j] < 0) {
					cost[i][j] = Integer.MAX_VALUE;
				} else {
					cost[i][j] = (int) Math.pow(cost[i][j], 2);
				}
			}
		}

		// minCost from i to len is found by trying
		// j between i to len and checking which
		// one has min value
		int minCost[] = new int[words.length];
		int result[] = new int[words.length];
		for (int i = words.length - 1; i >= 0; i--) {
			minCost[i] = cost[i][words.length - 1];
			result[i] = words.length;
			for (int j = words.length - 1; j > i; j--) {
				if (cost[i][j - 1] == Integer.MAX_VALUE) {
					continue;
				}
				if (minCost[i] > minCost[j] + cost[i][j - 1]) {
					minCost[i] = minCost[j] + cost[i][j - 1];
					result[i] = j;
				}
			}
		}
		int i = 0;
		int j;

		System.out.println("Minimum cost is " + minCost[0]);
		System.out.println("\n");
		// finally put all words with new line added in
		// string buffer and print it.
		StringBuilder builder = new StringBuilder();
		do {
			j = result[i];
			for (int k = i; k < j; k++) {
				builder.append(words[k] + " ");
			}
			builder.append("\n");
			i = j;
		} while (j < words.length);

		System.out.println(builder.toString());

	}

	public static void getSpacesOptimized(String[] words, int lineWidth) {

		int[] minCost = new int[words.length];

		// stores the index of last word in a line
		int[] result = new int[words.length];

		// if there is only one word, there is always be one line.
		minCost[words.length - 1] = 0;
		result[words.length - 1] = words.length - 1;

		for (int i = words.length - 2; i >= 0; i--) {

			int currentLength = -1;
			minCost[i] = Integer.MAX_VALUE;

			for (int j = i; j < words.length; j++) {

				int cost;
				currentLength += words[j].length() + 1;

				if (currentLength > lineWidth) {
					break;
				}

				// words starting from i to j are on same line and the line is last line.
				if (j == words.length - 1) {
					cost = 0;
				} else {
					cost = (lineWidth - currentLength) * (lineWidth - currentLength) + minCost[j + 1];

				}

				if (cost < minCost[i]) {
					minCost[i] = cost;
					result[i] = j;
				}
			}
		}

		int i = 0;
		int j;
		StringBuilder sb = new StringBuilder();

		do {

			j = result[i];

			for (int k = i; k <= j; k++) {
				sb.append(words[k] + " ");
			}
			sb.append("\n");

			i = j + 1;

		} while (i < words.length);

		System.out.println(sb.toString());
	}
}
