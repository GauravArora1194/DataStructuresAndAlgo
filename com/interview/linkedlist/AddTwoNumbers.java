package com.interview.linkedlist;

/**
 * 
 * Adds two numbers represented by linked list. most significant bits(MSB) are
 * at tail and least significant bits(LSB) are at head.
 * 
 * @author gauravarora02
 *
 */
public class AddTwoNumbers {

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

	// Add two numbers and return the head of the result. method take head of the
	// two list as input.
	public Node addNumbers(Node head1, Node head2) {

		Node first = head1;
		Node second = head2;

		int sum = 0, carry = 0;

		Node result = null;
		Node temp = null;
		Node prev = null;

		while (first != null || second != null) {

			sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);

			carry = (sum >= 10) ? 1 : 0; // if sum is >= 10

			sum = sum % 10;

			temp = new Node(sum);

			if (result == null) {

				result = temp;
			} else {

				prev.next = temp;

			}

			prev = temp;

			if (first != null) {
				first = first.next;
			}

			if (second != null) {

				second = second.next;
			}

		}

		if (carry > 0) {

			prev.next = new Node(carry);
		}

		return result;

	}

	public void display(Node node) {

		Node temp = node;

		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();

	}

	public static void main(String[] args) {

		AddTwoNumbers list1 = new AddTwoNumbers();
		AddTwoNumbers list2 = new AddTwoNumbers();

		list1.push(5);
		list1.push(6);
		list1.push(8);

		list1.display(list1.head);

		list2.push(8);
		list2.push(4);
		list2.push(2);

		list2.display(list2.head);

		Node result = list1.addNumbers(list1.head, list2.head);

		list1.display(result);

	}
}
