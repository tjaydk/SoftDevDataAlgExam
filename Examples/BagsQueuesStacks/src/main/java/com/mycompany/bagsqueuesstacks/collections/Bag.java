package com.mycompany.bagsqueuesstacks.collections;

import java.util.Iterator;

/**
 *
 * @author Dennis
 */
public class Bag<T> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public Bag() {
        this.first = null;
        size = 0;
    }

    public Bag(T item) {
        this.first = new Node(item);
        size = 0;
    }

    public void add(T item) {
        Node n = new Node(item);
        if (first == null) {
            first = n;
        } else {
            Node<T> current = first;
            first = n;
            first.next = current;
        }
        size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator {

        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return null != current;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
