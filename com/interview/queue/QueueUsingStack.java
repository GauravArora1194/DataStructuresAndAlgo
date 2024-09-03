package com.interview.queue;

import java.util.Stack;

public class QueueUsingStack <T> {

	// implementing queue using two stacks.
	// inserting elements in stack1 for enqueue(add) operation.
	// remove elements from stack2 for dequeue(remove) operation, if stack2 is empty
	// then move all elements from stack1 to stack2.

	
	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2 = new Stack<>();
	
	
	public void enqueue(T element) {
		
		stack1.push(element);
	}
	
	
	public void dequeue() {
		
		if(stack2.empty()) {
			
			while(!stack1.empty()) {
				
				stack2.push(stack1.pop());
			}
		}
		
		
		stack2.pop();
	}
	
	// return the element at front of queue without removing it.
	public T peek() {
		
		if(stack2.empty()) {
			
			while(!stack1.empty()) {
				
				stack2.push(stack1.pop());
			}
		}
		
		return stack2.peek();
	}
	
	
	
	public static void main(String[] args) {
		
		
		QueueUsingStack<Integer> queue = new QueueUsingStack<>();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		queue.dequeue();
		queue.dequeue();
		
		System.out.println("Element at front is : " + queue.peek());
		
		
	}
}
