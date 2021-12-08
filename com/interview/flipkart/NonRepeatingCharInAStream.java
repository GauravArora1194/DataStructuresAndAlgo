package com.interview.flipkart;

public class NonRepeatingCharInAStream {

	static Node head = null;
	static Node tail = null;

	public static void main(String[] args) {

		String s1 = "abadbc";

		System.out.println("Output : " + NonRepeatingCharString(s1));

		String s2 = "abcabc";

		System.out.println("Output : " + NonRepeatingCharString(s2));

	}

	public static String NonRepeatingCharString(String str) {

		char[] chars = str.toCharArray();
		boolean[] repeated = new boolean[chars.length];

		Node[] nodeAddress = new Node[chars.length];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < chars.length; i++) {

			char c = chars[i];

			if (!repeated[c - 'a']) {

				if (nodeAddress[c - 'a'] == null) {

					Node node = new Node(c);
					addNode(node);
					nodeAddress[c - 'a'] = node;

				} else {

					removeNode(nodeAddress[c - 'a']);
					repeated[c - 'a'] = true;
				}
			}

			if (head == null) {
				sb.append("#");
			} else {
				sb.append(head.data);
			}

		}

		return sb.toString();

	}

	private static void removeNode(Node node) {

		if (head == node && tail == node) {
			head = null;
			tail = null;
		} else if (node == head) {
			head = head.next;
			head.previous = null;
		} else if (node == tail) {
			tail = tail.previous;
			tail.next = null;
		} else {
			node.next.previous = node.previous;
			node.previous.next = node.next;
		}

	}

	private static void addNode(Node node) {

		if (head == null && tail == null) {

			head = node;
			tail = node;
		} else {

			tail.next = node;
			node.previous = tail;
			tail = node;
		}

	}

	static class Node {

		char data;
		Node next;
		Node previous;

		Node(char data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}
}
