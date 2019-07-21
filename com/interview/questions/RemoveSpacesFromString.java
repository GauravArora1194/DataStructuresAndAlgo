package com.interview.questions;

public class RemoveSpacesFromString {

	public static String removeSpace(String str) {

		StringBuilder newString = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {

			if ((str.charAt(i)) != ' ') {
				newString.append(str.charAt(i));
			}
		}

		return newString.toString();
	}

	public static void main(String[] args) {

		String str = "      g  eeks   for ge  eeks  ";

		System.out.println("Original String : " + str);
		String spaceRemovedString = removeSpace(str);

		System.out.println("New String : " + spaceRemovedString);

	}

}
