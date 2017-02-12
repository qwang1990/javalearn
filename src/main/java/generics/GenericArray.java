package generics;

/**
 * Created by wangqi on 17/2/12.
 */
public class GenericArray<T> {
    private T[] array;
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<Integer>(10);
       //因为实际运行时类型还是object，所以尝试将结果用Integer[]来捕获
        //就会得到ClassCastException
       // Integer[] is = gai.rep();
        Object[] oa = gai.rep();
    }
}
