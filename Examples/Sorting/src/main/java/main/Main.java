package main;

import com.mycompany.sorting.MergeSort;

/**
 *
 * @author Dennis
 */
public class Main {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        
        Integer[] list = new Integer[]{2, 4, 5, 2, 6, 8};
        ms.sortBU(list);
        
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
