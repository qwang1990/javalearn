package holding;

import concurrent.ReaderWriterList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by wangqi on 17/2/11.
 */
class ReversibleArray<T> extends ArrayList<T> {
    public ReversibleArray(Collection<T> c) {super(c);}

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;
                    public boolean hasNext() {
                        return current > -1;
                    }

                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArray<String> ral =
                new ReversibleArray<String>(
                        Arrays.asList("to be or not to be".split(" "))
                );

        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : ral.reversed()) {
            System.out.print(s + " ");
        }

    }
}
