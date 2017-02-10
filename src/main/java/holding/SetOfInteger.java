package holding;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by wangqi on 17/2/10.
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<Integer>();
        for (int i=0;i<10000;i++) {
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);
    }
}
