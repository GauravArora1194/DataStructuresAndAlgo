package com.interview.questions;

public class ShallowCopyDeepCopy {

	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A(20, "GeeksForGeeks");

		// cloning 'a' and holding
		// new cloned object reference in b

		// down-casting as clone() return type is Object. Shallow copy is created i.e b will initially have same values as a object.
		A b = (A) a.clone();
		
		System.err.println(a);
		System.out.println(b);
		
		System.out.println(a == b); // will return false
		
		// b.i = 10;
		// b.s = "Geeks";
				
		System.out.println(a.i);
		System.out.println(a.s);
		
		System.out.println(b.i);
		System.out.println(b.s);

	}

}

class A implements Cloneable {
	int i;
	String s;

	// A class constructor
	public A(int i, String s) {
		this.i = i;
		this.s = s;
	}

	// Overriding clone() method
	// by simply calling Object class
	// clone() method.
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}