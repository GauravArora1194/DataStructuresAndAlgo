package com.interview.paytm;

public class MethodOverloading {

	public void print(Test test) {

		System.out.println("Printing test!");
	}

	public void print(String str) {

		System.out.println("Printing string!");
	}

	public static void main(String[] args) {

		// new MethodOverloading().print(null); // this gives ambiguous compilation
		// error.

		new MethodOverloading().print("Gaurav");
		new MethodOverloading().print(new Test());

	}

}

class Test {

	String subject;

	Test(String subject) {

		this.subject = subject;
	}

	public Test() {

		// if we specify parameterized constructor then we have to explicitly specify
		// empty constructor.
	}
}
