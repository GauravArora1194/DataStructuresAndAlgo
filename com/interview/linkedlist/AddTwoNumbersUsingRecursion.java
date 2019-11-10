package com.interview.linkedlist;

/**
 * 
 * Adds two numbers represented by linked list. most significant bits(MSB) are
 * at head and least significant bits(LSB) are at tail.
 * 
 * @author gauravarora02
 *
 */
public class AddTwoNumbersUsingRecursion {

	int carry = 0;

	Node head1, head2, result;
	Node current;

	class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void display(Node head) {

		Node temp = head;

		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public int getCount(Node node) {

		if (node == null) {
			return 0;
		}

		return 1 + getCount(node.next);
	}

	public void push(int sum, int list) {

		Node node = new Node(sum);

		if (list == 1) {

			node.next = head1;
			head1 = node;
		} else if (list == 2) {

			node.next = head2;
			head2 = node;
		} else {

			node.next = result;
			result = node;
		}
	}

	public void addListOfSameSize(Node node1, Node node2) {

		if (node1 == null || node2 == null) {
			return;
		}

		addListOfSameSize(node1.next, node2.next);

		int sum = node1.data + node2.data + carry;

		carry = (sum >= 10) ? 1 : 0;

		sum = sum % 10;

		push(sum, 3);

	}

	void propagateCarry(Node head1) {

		if (head1 != current) {

			propagateCarry(head1.next);

			int sum = head1.data + carry;
			carry = (sum >= 10) ? 1 : 0;

			sum = sum % 10;

			push(sum, 3);
		}

	}

	void addLists() {

		if (head1 == null) {

			result = head2;
			return;
		}

		if (head2 == null) {

			result = head1;
			return;
		}

		int size1 = getCount(head1);
		int size2 = getCount(head2);

		if (size1 == size2) {

			addListOfSameSize(head1, head2);

		} else {

			// first list should always be the largest one.
			if (size1 < size2) {

				Node temp = head1;
				head1 = head2;
				head2 = temp;

			}

			int diff = Math.abs(size1 - size2);

			// Move diff number of node is first list

			Node temp = head1;

			while (diff >= 0) {

				current = temp;
				temp = temp.next;
				diff = diff - 1;
			}

			addListOfSameSize(current, head2);

			propagateCarry(head1);

		}

		if (carry > 0) {

			push(carry, 3);
		}

	}

	public static void main(String[] args) {

		AddTwoNumbersUsingRecursion list = new AddTwoNumbersUsingRecursion();

		list.push(9, 1);
		list.push(9, 1);
		list.push(9, 1);

		list.push(8, 2);
		list.push(1, 2);

		list.display(list.head1);

		list.display(list.head2);

		list.addLists();

		list.display(list.result);
	}

}
