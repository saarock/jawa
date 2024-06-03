package org.example.util.ds;

public class Queue<T> {
    private int size;
    private int front;
    private int rear;
    private T[] data;
    private int count;

    @SuppressWarnings("unchecked")
    public Queue(int size)  {
        this.size = size;
        this.data = (T[]) new Object[size];
        this.front = 0;
        this.rear = -1;
        this.count = -1;
    }

    public void enqueue(T data) throws Exception {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        this.data[front] = data;
        rear = (rear + 1) % size;
        this.data[rear] = data;
        this.count++;
    }

    public T dequeue() throws Exception {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }

        T data = this.data[this.front];
        this.front = (front + 1)  % size;
        this.count--;
        return data;

    }
    public int getSize() {
        return this.size;
    }

    public boolean isFull() {
        if (this.count + 1 >= this.getSize()) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.count <= -1) {
            return true;
        }
        return false;
    }

    public T peek () {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return this.data[this.front];
    }

}
