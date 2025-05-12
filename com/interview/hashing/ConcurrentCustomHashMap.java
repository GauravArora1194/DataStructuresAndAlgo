package com.interview.hashing;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentCustomHashMap<K, V> {

    static class Node<K, V> {
        final int hashCode;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hashCode, K key, V value) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
        }
    }

    private final Node<K, V>[] bucket;
    private final ReentrantLock[] locks;
    private static final int MAX_CAPACITY = 1 << 4;
    private int size = 0;

    ConcurrentCustomHashMap() {
        this(MAX_CAPACITY);
    }

    ConcurrentCustomHashMap(int maxCapacity) {
        this.bucket = new Node[maxCapacity];
        this.locks = new ReentrantLock[maxCapacity];
        for (int i = 0; i < maxCapacity; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    public void put(K key, V value) {
        int hash = hash(key);
        int index = hash % bucket.length;
        locks[index].lock();

        try {
            Node<K, V> head = bucket[index];
            Node<K, V> curr = head;

            while (curr != null) {
                if (curr.hashCode == hash && curr.key.equals(key)) {
                    curr.value = value;
                    return;
                }

                curr = curr.next;
            }

            Node<K, V> newNode = new Node<>(hash, key, value);
            newNode.next = head;
            bucket[index] = newNode;
            size++;

        } finally {
            locks[index].unlock();
        }


    }

    public V get(K key) {

        int hash = hash(key);
        int index = hash % bucket.length;
        locks[index].lock();

        try {
            Node<K, V> curr = bucket[index];

            while (curr != null) {
                if (curr.hashCode == hash && curr.key.equals(key)) {
                    return curr.value;
                }
                curr = curr.next;
            }
            return null;
        } finally {
            locks[index].unlock();
        }
    }

    public void remove(K key) {

        int hash = hash(key);
        int index = hash % bucket.length;

        locks[index].lock();
        try {

            Node<K, V> curr = bucket[index];
            Node<K, V> prev = null;

            while (curr != null) {

                if (curr.hashCode == hash && curr.key.equals(key)) {

                    if (prev == null) {
                        bucket[index] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    return;

                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }

        } finally {
            locks[index].unlock();
        }
    }


    public int size() {
        return size;
    }

    private int hash(K key) {
        return key != null ? key.hashCode() : 0;
    }


    public static void main(String[] args) {
        ConcurrentCustomHashMap<String, String> map = new ConcurrentCustomHashMap<>();

        map.put("foo", "bar");
        map.put("baz", "qux");

        System.out.println(map.get("foo"));  // Output: bar
        map.remove("foo");
        System.out.println(map.get("foo"));  // Output: null
    }
}
