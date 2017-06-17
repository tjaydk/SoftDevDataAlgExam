package com.mycompany.bagsqueuesstacks.collections;

import java.util.Iterator;

/**
 *
 * @author Dennis
 */
public class Stack<T> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public Stack() {
        this.first = null;
        this.size = 0;
    }

    public void push(T item) {
        if (first == null) {
            first = new Node(item);
        } else {
            Node<T> current = first;
            first = new Node(item);
            first.next = current;
        }
        size++;
    }

    public T pop() {
        Node<T> nodeToPop = first;
        first = first.next;
        size--;
        return nodeToPop.item;
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
