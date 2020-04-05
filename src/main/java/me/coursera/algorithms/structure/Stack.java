package me.coursera.algorithms.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterable<T> {

    private Node first = null;

    @Override
    public Iterator<T> iterator() {
        return new ListIterable();
    }

    class ListIterable implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        T item;
        Node next;
    }
}
