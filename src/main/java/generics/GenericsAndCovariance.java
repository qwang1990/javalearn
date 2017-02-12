package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqi on 17/2/12.
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();
        //报错。。。
        //flist.add(new Apple());
        //flist.add(new Fruit());
        flist.add(null);
    }
}
