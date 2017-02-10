package holding;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wangqi on 17/2/10.
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Integer> pets = Arrays.asList(1,2,3,4,5,6,7);
        ListIterator<Integer> it = pets.listIterator();
        while (it.hasNext())
            System.out.print(it.next()+", "+it.nextIndex()
            +", "+it.previousIndex()+"; ");
        System.out.println();
        while (it.hasPrevious())
            System.out.print(it.previous().intValue() + " ");
        System.out.println();

    }
}
