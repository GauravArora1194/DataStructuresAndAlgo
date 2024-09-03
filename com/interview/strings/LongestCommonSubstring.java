package com.interview.strings;

public class LongestCommonSubstring {

	// given two string , the task is to return the length of longest common
	// substring

	// using dynamic approach
	public static int findLengthOfCommonSubString(String str1, String str2) {

		int rowLength = str2.length() + 1;
		int colLength = str1.length() + 1;

		int maxLength = 0;
		int startIndex = 0;
		int endIndex = 0;

		int[][] matrix = new int[rowLength][colLength];

		for (int i = 1; i < rowLength; i++) {

			for (int j = 1; j < colLength; j++) {

				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {

					matrix[i][j] = matrix[i - 1][j - 1] + 1;

				}

				if (matrix[i][j] > maxLength) {

					maxLength = matrix[i][j];
					startIndex = i;
					endIndex = j;
				}
			}
		}

		System.out.println("Longest common substring : ");
		while (matrix[startIndex][endIndex] != 0) {

			System.out.print(str1.charAt(endIndex - 1));
			startIndex--;
			endIndex--;
		}

		return maxLength;

	}

	public static void main(String[] args) {

		String str1 = "geeksforgeeks";
		String str2 = "geeksquiz";

		String str3 = "abcdxyz";
		String str4 = "xyzabcd";

		String str5 = "zxabcdezy";
		String str6 = "yzabcdezx";

		System.out.println("\nMax length of substring is : " + findLengthOfCommonSubString(str1, str2));
		System.out.println("\nMax length of substring is : " + findLengthOfCommonSubString(str3, str4));

		System.out.println("\nMax length of substring is : " + findLengthOfCommonSubString(str5, str6));
	}
}
