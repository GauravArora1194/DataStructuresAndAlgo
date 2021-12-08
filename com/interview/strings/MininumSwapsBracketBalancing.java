package com.interview.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/minimum-swaps-bracket-balancing/
 * 
 * @author gauravarora02
 *
 */
public class MininumSwapsBracketBalancing {

	public static void main(String[] args) {

		String str = "[]][][";

		System.out.println(getMinSwaps(str));
		System.out.println(getMinSwapsOptimized(str));

		String str1 = "[[][]]";

		System.out.println(getMinSwaps(str1));
		System.out.println(getMinSwapsOptimized(str1));
	}

	// Space complexity - O(n)
	// Time Complexity - O(n)
	public static int getMinSwaps(String str) {

		List<Integer> openBracketIndexs = new ArrayList<>();

		char[] s = str.toCharArray();

		for (int i = 0; i < s.length; i++) {

			if (s[i] == '[') {
				openBracketIndexs.add(i);
			}
		}

		int result = 0;
		int openBracketCount = 0;
		int listIndex = 0;

		for (int i = 0; i < s.length; i++) {

			if (s[i] == '[') {
				openBracketCount++;
				listIndex++;
			} else {
				openBracketCount--;
			}

			// extra closing bracket in present
			if (openBracketCount < 0) {

				result += openBracketIndexs.get(listIndex) - i;

				// swap brackets
				char c = s[i];
				s[i] = s[openBracketIndexs.get(listIndex)];
				s[openBracketIndexs.get(listIndex)] = c;

				openBracketCount = 1;
				listIndex++;

			}
		}

		return result;
	}

	// Space Complexity - O(1)
	// Time Complexity - O(n)
	public static int getMinSwapsOptimized(String str) {

		int openBracketCount = 0;
		int closeBracketCount = 0;

		int minSwaps = 0;

		int unbalance = 0;

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (c == '[') {
				openBracketCount++;

				if (unbalance > 0) {

					minSwaps += unbalance;

					unbalance--;
				}
			} else {
				closeBracketCount++;

				unbalance = closeBracketCount - openBracketCount;
			}
		}

		return minSwaps;
	}

}
