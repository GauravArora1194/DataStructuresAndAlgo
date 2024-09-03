package com.interview.searchtypes;

class A{
	
	public void print() {
		System.out.println("In a");
	}
}

public class Unboxing extends A{

	public void print() {
		System.out.println("In b");
	}
	
	public static void main(String[] args) {
		
		Unboxing b = (Unboxing) new A();
		
		b.print();
		
	}
		
		

	}
