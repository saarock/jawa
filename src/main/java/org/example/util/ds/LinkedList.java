package org.example.util.ds;


import java.util.NoSuchElementException;

public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;
    private final int size;
    private int index = -1;

   public LinkedList(int size) {
        this.size = size;
        this.head = null;
        this.tail = null;
    }

    // Default constructor
    public LinkedList() {
        this.size = 50;
    }

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T data;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to add the node at the first
    public void addFirst(T data) {
        if (this.index + 1 >= this.size) {
            System.out.println("ds.LinkedList is full");
            return;
        }
        Node<T> node = new Node<>(data);
        if (this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
            this.index++;
            return;
        }
        assert this.head != null;
        this.head.prev = node;
        node.next = this.head;
        this.head = node;
        this.index++;
    }

    // Method to add the node at the last
    public void addLast(T data) {
        if (this.index + 1 >= this.size) {
            System.out.println("ds.LinkedList is full");
            return;
        }
        Node<T> node = new Node<>(data);
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
            this.index++;
            return;
        }

        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
        this.index++;

    }

    // Method to remove the node from the first
    public T removeFirst() {
        if (this.head == null) {
            return null;
        }

        T value = this.head.data;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }
        this.index--;
        return value;
    }

    // Method to remove the node from the last
    public T removeLast() {
        if (this.tail == null) {
            return null;
        }

        T value = this.tail.data;
        this.tail = this.tail.prev;
        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        this.index--;
        return value;
    }



    // Method to check that data is exist or not at the linkedList
    public boolean contains(T data) {
        Node<T> currentNode = this.head;
        if (currentNode == null) {
            return false;
        }
        while (currentNode.next != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }
    // Method to remove the node from the linkedList if exist
    public T remove(int index) {
        if (isEmpty()) {
            return null; // If the list is empty, return null
        }
        if (index < 0 || index > this.index) {
            return null; // If the index is out of bounds, return null
        }

        Node<T> currentNode = head;
        for (int i=0; i<index; i++) {
            currentNode = currentNode.next;
        }

        Node<T> prevNode =currentNode.prev;
        Node<T> nextNode = currentNode.next;
        if (prevNode == null) {
            return removeFirst();
        } else if (nextNode == null) {
            return removeLast();
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        this.index--; // Decrement the index after removal
        return currentNode.data;
    }



    // Method to check the linkedList is empty ot not
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    // Method to get the size of the linkedList
    public int getSize() {
        return this.size;
    }

    public T get(int index) {
        Node<T> currentNode = this.head;
        if (this.isEmpty()) {
            System.out.println("LinkedList is Empty");
            return null;
        }
        if (index > this.index) {
            return null;
        }

        int currentIndex = 0;
        while (currentNode.next != null && index != currentIndex) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode.data;

    }
}
