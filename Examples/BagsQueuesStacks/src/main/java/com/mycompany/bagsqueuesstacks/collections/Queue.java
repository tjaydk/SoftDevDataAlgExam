package com.mycompany.bagsqueuesstacks.collections;

import java.util.Iterator;

/**
 *
 * @author Dennis
 */
public class Queue<T> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public Queue() {
        this.first = null;
        size = 0;
    }

    public void enqueue(T item) {
        if (first == null) {
            first = new Node(item);
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(item);
        }
        size++;
    }

    public T dequeue() {
        Node<T> itemToDequeue = first;
        first = first.next;
        size--;
        return itemToDequeue.item;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
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
        };
    }
}
