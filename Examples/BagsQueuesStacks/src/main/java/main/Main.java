package main;

import com.mycompany.bagsqueuesstacks.collections.Bag;

/**
 *
 * @author Dennis
 */
public class Main {
    public static void main(String[] args) {
        Bag<Integer> b = new Bag();
        b.add(2);
        //b.add(4);
        //b.add(1);
        //b.add(7);
        for (Integer integer : b) {
            System.out.println(integer);
        }
        //b.printBag();
    }
}
