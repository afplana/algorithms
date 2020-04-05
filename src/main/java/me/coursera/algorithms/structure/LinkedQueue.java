package me.coursera.algorithms.structure;

public class LinkedQueue<T> {
    private Node first;
    private Node last;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T item) {
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else old.next = last;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }
}
