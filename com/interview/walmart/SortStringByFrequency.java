package com.interview.walmart;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 
 * @author gauravarora02
 *
 */
public class SortStringByFrequency {

	public static void main(String[] args) {

		String s = "tree";
		System.out.println(frequencySort(s));
	}

	public static String frequencySort(String s) {
		char[] chars = s.toCharArray();

		int[] arr = new int[256];

		for (int i = 0; i < chars.length; i++) {

			arr[chars[i]]++;
		}

		Arrays.sort(arr);
		int j = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != 0) {

				chars[j] = (char) i;
			}
		}

		return new String(chars);
	}
}
