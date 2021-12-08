package com.interview.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {

		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");

		System.out.println(wordBreak(s, wordDict));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {

		int[] dp = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {

			for (int j = 0; j <= i; j++) {

				String subStr = s.substring(j, i + 1);

				if (wordDict.contains(subStr)) {

					if (j > 0) {
						dp[i] += dp[j - 1];
					} else {
						dp[i] += 1;
					}

				}
			}
		}

		return dp[s.length() - 1] > 0;

	}
}
