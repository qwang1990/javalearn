package containers;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by wangqi on 17/2/13.
 */



public class SortedSetDemo {

    public  <T>  void get(T t) {
        System.out.println("T");
    }

    public  void get(Integer t) {
        System.out.println("int");
    }

    public static void main(String[] args) {
        SortedSetDemo s = new SortedSetDemo();
        s.get(1L);


        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet,"one two three four five six seven eight".split(" "));
        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);
        Iterator<String> it = sortedSet.iterator();
        for(int i=0;i<=6;i++) {
            System.out.print(it.next() + " ");
        }

    }
}
