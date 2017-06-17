package main;

import com.mycompany.sorting.MergeSort;
import com.mycompany.sorting.QuickSort;

/**
 *
 * @author Dennis
 */
public class Main {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
        
        Integer[] list1 = new Integer[]{2, 4, 5, 2, 6, 8};
        Integer[] list2 = new Integer[]{2, 4, 5, 2, 6, 8};
        ms.sortBU(list1);
        qs.sort(list2);
        
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        
        for (Integer integer : list2) {
            System.out.println(integer);
        }
    }
}
