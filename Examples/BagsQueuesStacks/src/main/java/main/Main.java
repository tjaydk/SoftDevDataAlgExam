package main;

import com.mycompany.bagsqueuesstacks.collections.Bag;
import com.mycompany.bagsqueuesstacks.collections.Queue;
import com.mycompany.bagsqueuesstacks.collections.Stack;

/**
 *
 * @author Dennis
 */
public class Main {
    public static void main(String[] args) {
        Bag<Integer> b = new Bag();
        b.add(2);
        b.add(4);
        b.add(1);
        b.add(7);
        for (Integer integer : b) {
            System.out.println(integer);
        }
        Queue<String> q = new Queue();
        q.enqueue("Hello");
        q.enqueue("World");
        for (String string : q) {
            System.out.println(string);
        }
        System.out.println(q.dequeue());
        Stack<Float> s = new Stack();
        s.push(2.2F);
        s.push(5.7F);
        s.push(1.9F);
        for (Float float1 : s) {
            System.out.println(float1);
        }
        System.out.println(s.pop());
    }
}
