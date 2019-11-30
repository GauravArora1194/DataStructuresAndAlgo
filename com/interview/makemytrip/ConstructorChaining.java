package com.interview.makemytrip;

public class ConstructorChaining {

	private static int x = 10;
	private static int y = 20;
	

	private ConstructorChaining() {
		this(5);
	}

	private ConstructorChaining(int x) {
		this(x, y);
	}

	private ConstructorChaining(int x, int y) {

		System.out.println(x * y);

	}

	public static void main(String[] args) {

		ConstructorChaining c = new ConstructorChaining();

	}

}
