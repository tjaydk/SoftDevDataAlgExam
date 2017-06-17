package com.mycompany.sorting;

import java.lang.reflect.Array;

/**
 *
 * @author Dennis
 */
public class MergeSort<T extends Comparable<T>> {

    private T[] aux;

    public MergeSort() {
        this.aux = null;
    }

    public void sortTD(T[] arr) {
        this.aux = (T[]) Array.newInstance(Comparable.class, arr.length);
        sort(arr, 0, arr.length - 1);
    }
    
    public void sortBU(T[] arr) {
        this.aux = (T[]) Array.newInstance(Comparable.class, arr.length);
        sort(arr);
    }

    /***
     * Bottom up sorting
     * @param a 
     */
    public void sort(T[] a) {
        int N = a.length;
        for (int sz = 1; sz < N; sz = sz + sz) // sz: subarray size
        {
            for (int lo = 0; lo < N - sz; lo += sz + sz) // lo: subarray index
            {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    /***
     * Top down sorting
     * @param a
     * @param lo
     * @param hi 
     */
    private void sort(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(T[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) <= 0) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }

        }
    }
}
