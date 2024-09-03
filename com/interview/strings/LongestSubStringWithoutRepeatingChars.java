package com.interview.strings;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChars {

	// finds the length of longest substring without repeating characters.
	// for example - geeksforgeeks -> eksforge.

	static final int NO_OF_CHARS = 256;

	static int longestUniqueSubsttr(String str) {
		int n = str.length();
		int cur_len = 1; // length of current substring
		int max_len = 1; // result
		int prev_index; // previous index
		int i;
		int visited[] = new int[NO_OF_CHARS];

		/*
		 * Initialize the visited array as -1, -1 is used to indicate that character has
		 * not been visited yet.
		 */
		for (i = 0; i < NO_OF_CHARS; i++) {
			visited[i] = -1;
		}

		/*
		 * Mark first character as visited by storing the index of first character in
		 * visited array.
		 */
		visited[str.charAt(0)] = 0;

		/*
		 * Start from the second character. First character is already processed
		 * (cur_len and max_len are initialized as 1, and visited[str[0]] is set
		 */
		for (i = 1; i < n; i++) {
			prev_index = visited[str.charAt(i)];

			/*
			 * If the current character is not present in the already processed substring or
			 * it is not part of the current NRCS, then do cur_len++
			 */
			if (prev_index == -1 || i - cur_len > prev_index)
				cur_len++;

			/*
			 * If the current character is present in currently considered NRCS, then update
			 * NRCS to start from the next character of previous instance.
			 */
			else {
				/*
				 * Also, when we are changing the NRCS, we should also check whether length of
				 * the previous NRCS was greater than max_len or not.
				 */
				if (cur_len > max_len)
					max_len = cur_len;

				cur_len = i - prev_index;
			}

			// update the index of current character
			visited[str.charAt(i)] = i;
		}

		// Compare the length of last NRCS with max_len and
		// update max_len if needed
		if (cur_len > max_len)
			max_len = cur_len;

		return max_len;
	}

	private static int longestUniqueSubsttrUsingHashmap(String str) {

		int currentLength = 0;
		int maxLength = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			if (!map.containsKey(str.charAt(i)) || (notInCurrentWindow(map, str, currentLength, i))) {

				currentLength++;

			} else {

				if (currentLength > maxLength)
					maxLength = currentLength;

				currentLength = i - (map.get(str.charAt(i)));
			}

			map.put(str.charAt(i), i);

		}

		if (currentLength > maxLength)
			maxLength = currentLength;

		return maxLength;
	}

	private static boolean notInCurrentWindow(Map<Character, Integer> map, String str, int currentLength, int i) {

		if (map.containsKey(str.charAt(i))) {

			int previousIndex = map.get(str.charAt(i));

			if (i - currentLength > previousIndex)
				return true;
			else
				return false;

		}

		return false;
	}

	public static int longestSubString(String str) {

		int i = -1;
		int j = -1;
		int maxLength = 0;

		Map<Character, Integer> map = new HashMap<>();

		while (true) {

			boolean f1 = false;
			boolean f2 = false;

			while (i < str.length() - 1) {

				f1 = true;
				i++;
				char c = str.charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);

				if (map.get(c) == 2) {
					break;
				} else {
					int len = i - j;
					maxLength = Math.max(maxLength, len);

				}

			}

			while (j < i) {

				f2 = true;
				j++;
				char c = str.charAt(j);
				map.put(c, map.get(c) - 1);

				if (map.get(c) == 1) {
					break;
				}
			}

			if (f1 == false && f2 == false) {
				break;
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		System.out.println("The input string is " + str);
		int len = longestUniqueSubsttr(str);
		int len1 = longestUniqueSubsttrUsingHashmap(str);
		System.out.println("The length of " + "the longest non repeating character is " + len);

		System.out.println("The length of " + "the longest non repeating character using hashmap is " + len1);

		System.out.println(longestSubString("ggububgvfk"));

		System.out.println(Integer.valueOf("-123"));
		System.out.println(Integer.parseInt("-123"));

		System.out.println(Integer.valueOf("321"));
		System.out.println(Integer.parseInt("321"));
	}

}
