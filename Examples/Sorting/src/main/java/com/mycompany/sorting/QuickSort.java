package com.mycompany.sorting;

import java.lang.reflect.Array;
import java.util.Random;

/**
 *
 * @author Dennis
 */
public class QuickSort<T extends Comparable<T>> {

    private T[] aux;

    public QuickSort() {

    }

    public void sort(T[] a) {
        T[] shuffledArr = shuffle(a);
        sort(shuffledArr, 0, a.length - 1);
    }

    private void sort(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        T v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                swap(a, lt++, i++);
            } else if (cmp > 0) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        } // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private int partition(T[] a, int lo, int hi) {
        int i = lo, j = hi + 1; // left and right scan indices
        T v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (a[++i].compareTo(v) < 0) {
                if (i == hi) {
                    break;
                }
            }
            while (v.compareTo(a[--j]) > 0) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j); // Put v = a[j] into position
        return j;
    }

    private T[] shuffle(T[] a) {
        Random ran = new Random();
        for (int i = 0; i < a.length; i++) {
            int randomIndex = ran.nextInt(a.length - 1);
            swap(a, i, randomIndex);
        }
        return a;
    }

    private void swap(T[] a, int i, int j) {
        T t1 = a[i];
        T t2 = a[j];
        a[i] = t2;
        a[j] = t1;
    }

}
