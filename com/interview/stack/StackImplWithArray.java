package com.interview.stack;

public class StackImplWithArray {

	private static final int MAX = 1000;
	int top;
	int arr[] = new int[MAX];

	public StackImplWithArray() {

		top = -1;
	}

	public boolean isEmpty() {

		return (top < 0);

	}

	public boolean push(int item) {

		if (top >= MAX) {
			System.out.println("Stack overflowed!");
			return false;
		} else {
			arr[++top] = item;
			System.out.println(item + "pushed successfully!");
			return true;
		}

	}

	public int pop() {

		if (top < 0) {
			System.out.println("Stack underflowed!");
			return -1;
		} else {

			return arr[top--];
		}

	}

	public static void main(String[] args) {

		StackImplWithArray stack = new StackImplWithArray();

		/*
		 * System.out.println("Is Stack Empty : " + stack.isEmpty()); stack.push(100);
		 * stack.push(200); stack.push(300); stack.push(500);
		 * System.out.println(stack.pop() + " popped from stack");
		 * System.out.println(stack.pop() + " popped from stack");
		 * System.out.println(stack.pop() + " popped from stack");
		 * System.out.println(stack.pop() + " popped from stack");
		 * System.out.println("Is Stack Empty : " + stack.isEmpty());
		 */

		for (int i = 0; i < 1001; i++) {
			stack.push(i);
		}

		// PROS : Easy to implement.Memory is saved as pointers are not involved.
		// CONS : It is not dynamic.It doesn't grow and shrink depending on needs at
		// runtime.
	}

}
