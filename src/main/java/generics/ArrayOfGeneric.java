package generics;

/**
 * Created by wangqi on 17/2/12.
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
      //  gia = (Generic<Integer>[])new Object[SIZE];
        gia = (Generic<Integer>[])new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        //compile error
        // gia[1] = new Object();
        //compile error
        //gia[2] = new Generic<Double>();
    }
}
