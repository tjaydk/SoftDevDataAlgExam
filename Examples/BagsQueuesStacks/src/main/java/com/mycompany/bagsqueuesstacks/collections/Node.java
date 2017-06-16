/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bagsqueuesstacks.collections;

/**
 *
 * @author Dennis
 */
public class Node<T> {
    public T item;
    public Node<T> next;
    
    public Node(T item) {
        this.item = item;
    }
}
