package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqi on 17/2/11.
 */
public class InfiniteRecursion {
    public String toString() {
        //这里使用this会产生递归调用
        //return " InfiniteRecursion address: " + this + "\n";
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for(int i=0;i<10;i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
