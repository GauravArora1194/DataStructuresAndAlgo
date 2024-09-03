package com.interview.linkedlist;

/**
 * 
 * Given a linked list. Rotate the list counter clockwise by k nodes
 * 
 * @author gauravarora02
 *
 */
public class RotateLinkedListCounterClockWise {

	Node head;

	class Node {

		int data;
		Node next;

		Node(int data) {

			this.data = data;
			this.next = null;
		}
	}

	public void push(int data) {

		Node node = new Node(data);

		node.next = head;

		head = node;

	}

	public void display() {

		Node temp = head;

		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public void rotateCounterClockwise(int k) {

		if (k == 0) {

			return;
		}

		Node temp = head;

		int count = 1;

		while (count < k && temp != null) {

			temp = temp.next;
			count++;
		}

		// Less number of nodes are present.
		if (temp == null) {
			return;
		}

		Node KthNode = temp;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = head;
		head = KthNode.next;
		KthNode.next = null;

	}

	public static void main(String[] args) {

		RotateLinkedListCounterClockWise list = new RotateLinkedListCounterClockWise();

		list.push(60);
		list.push(50);
		list.push(40);
		list.push(30);
		list.push(20);
		list.push(10);

		list.display();

		list.rotateCounterClockwise(4);

		list.display();
	}

}
