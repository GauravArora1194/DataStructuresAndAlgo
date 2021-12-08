package com.interview.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given string S consists of lowercase and uppercase letters, the task is to
 * find the number of substrings having an equal number of lowercase and
 * uppercase letters.
 * 
 * @author gauravarora02
 *
 */
public class SubStringsWithEqualLowerAndUperCase {

	public static void main(String[] args) {

		String s1 = "gEEk";
		String s2 = "WomensDAY";

		System.out.println(count(s1));
		System.out.println(count(s2));
		
		System.out.println(LongestSubString(s1));
		System.out.println(LongestSubString(s2));

	}

	public static int count(String s) {

		int count = 0;

		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				sum += 1;
			} else {
				sum += -1;
			}

			if (map.containsKey(sum)) {

				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}

		return count;
	}

	public static int LongestSubString(String s) {

		int maxLength = 0;

		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				sum += 1;
			} else {
				sum += -1;
			}

			if (map.containsKey(sum)) {

				int index = map.get(sum);
				int length = i - index;

				if (length > maxLength) {
					maxLength = length;
				}

			} else {
				map.put(sum, i);
			}
		}

		return maxLength;
	}
}
