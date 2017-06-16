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
    
    public void printBag() {
        Node<T> cur = first;
        while(null != cur.next) {
            System.out.println(cur.item);
            cur = cur.next;
        }
        System.out.println(cur.item);
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator(this.first);
    }

    private class BagIterator<T> implements Iterator {

        private Node<T> current;

        public BagIterator(Node<T> start) {
            this.current = start;
        }

        @Override
        public boolean hasNext() {
            return null != current.next;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return current.item;
            }
            T item = current.item;
            current = current.next;
            return item;
        }

    }
}
