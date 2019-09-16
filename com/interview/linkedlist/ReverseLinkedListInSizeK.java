package com.interview.linkedlist;

// given a linked list and a size k, 
// reverse every k elements in the list

public class ReverseLinkedListInSizeK {

	Node head;

	private class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addAtLast(int data) {

		Node node = new Node(data);

		if (head == null) {
			head = node;
			return;
		}

		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;
	}

	public void display() {

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public Node reverseEveryKElements(Node head, int size) {

		Node current = head;
		Node prev = null;
		Node next = null;
		int count = 0;

		while (current != null && count < size) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;

		}

		if (next != null) {

			head.next = reverseEveryKElements(next, size);
		}

		return prev;

	}

	public static void main(String[] args) {

		ReverseLinkedListInSizeK list = new ReverseLinkedListInSizeK();

		list.addAtLast(10);
		list.addAtLast(20);
		list.addAtLast(3);
		list.addAtLast(41);
		list.addAtLast(50);
		list.addAtLast(63);
		list.addAtLast(70);
		list.addAtLast(45);
		list.addAtLast(60);

		list.display();

		list.head = list.reverseEveryKElements(list.head, 3);

		list.display();

	}

}
