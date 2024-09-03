package com.interview.stack;

public class StackImplWithLinkedList {

	Node top;

	static class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public boolean isEmpty() {

		return (top == null);
	}

	public void push(int data) {

		Node newNode = new Node(data);
		/*
		 * if(top == null) { top = newNode; return; }
		 */

		newNode.next = top;
		top = newNode;
		System.out.println("Item " + data + " pushed successfully!");

	}

	public int pop() {

		if (top == null) {
			System.out.println("Stack is empty");
			return -1;
		} else {

			int item = top.data;
			top = top.next;
			return item;
		}
	}

	public static void main(String[] args) {

		StackImplWithLinkedList stack = new StackImplWithLinkedList();

		System.out.println("Is Stack Empty : " + stack.isEmpty());
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(500);
		System.out.println(stack.pop() + " popped from stack");
		System.out.println(stack.pop() + " popped from stack");
		System.out.println("Is Stack Empty : " + stack.isEmpty());
		System.out.println(stack.pop() + " popped from stack");
		System.out.println(stack.pop() + " popped from stack");
		System.out.println("Is Stack Empty : " + stack.isEmpty());

	}

}
