package holding;

import java.util.*;

/**
 * Created by wangqi on 17/2/10.
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[] moreIns = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreIns));
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection,moreIns);
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1,99);
        //Arrays.asList()的输出直接当成list，因为其底层是数组，因此不能调整尺寸
        //list.add(1);      //运行时报错

    }
}
