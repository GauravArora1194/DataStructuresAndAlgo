package com.interview.queue;

import java.util.HashMap;
import java.util.Map;

class LFUCache {

	private int capacity;
	private int count;
	private int minFrequency;
	private Map<Integer, Node> cache;
	private Map<Integer, DoubleLinkedList> freqMap;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		this.minFrequency = 0;
		this.cache = new HashMap<>();
		this.freqMap = new HashMap<>();
	}

	public int get(int key) {

		Node node = cache.get(key);

		if (node != null) {
			updateNode(node);
			return node.value;
		} else {
			return -1;
		}

	}

	public void put(int key, int value) {

		if (capacity == 0) {
			return;
		}

		Node node = cache.get(key);

		// if key is already present, update it.
		if (node != null) {

			node.value = value;
			updateNode(node);

		} else {
			node = new Node(key, value);

			// if there is space in cache;
			if (count < capacity) {
				count++;
				DoubleLinkedList list = freqMap.getOrDefault(1, new DoubleLinkedList());
				list.add(node);
				freqMap.put(1, list);

			} else {

				DoubleLinkedList minFreqlist = freqMap.get(minFrequency);

				cache.remove(minFreqlist.tail.previous.key);
				minFreqlist.remove(minFreqlist.tail.previous);
				DoubleLinkedList list = freqMap.getOrDefault(1, new DoubleLinkedList());
				list.add(node);
				freqMap.put(1, list);

			}

			minFrequency = 1;
			cache.put(key, node);
		}

	}

	public void updateNode(Node node) {

		int freq = node.frequency;
		DoubleLinkedList list = freqMap.get(freq);
		list.remove(node);

		if (freq == minFrequency && list.size == 0) {
			minFrequency++;
		}

		freq++;

		DoubleLinkedList list1 = freqMap.getOrDefault(freq, new DoubleLinkedList());
		node.frequency = freq;
		list1.add(node);
		freqMap.put(freq, list1);
	}

	class Node {

		int key;
		int value;
		int frequency;
		Node next;
		Node previous;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.previous = null;
			this.frequency = 1;
		}
	}

	class DoubleLinkedList {

		int size;
		Node head;
		Node tail;

		DoubleLinkedList() {
			this.head = new Node(-1, -1);
			this.tail = new Node(-1, -1);
			this.size = 0;

			head.next = tail;
			tail.previous = head;
		}

		public void add(Node node) {

			node.next = head.next;
			node.next.previous = node;
			node.previous = head;
			head.next = node;
			size++;

		}

		public void remove(Node node) {

			node.next.previous = node.previous;
			node.previous.next = node.next;
			size--;
		}
	}
}
