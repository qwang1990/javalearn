package containers;

import java.util.WeakHashMap;

/**
 * Created by wangqi on 17/2/13.
 */
class Element {
    private String ident;
    public Element(String id) {
        ident = id;
    }
    public String toString() {
        return ident;
    }
    public int hashCode() {
        return ident.hashCode();
    }
    public boolean equals(Object r) {
        return r instanceof Element &&
                ident.equals(((Element)r).ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " +
                getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {

    public Key(String id) {
        super(id);
    }
}

class Value extends Element {

    public Value(String id) {
        super(id);
    }
}

public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 100;
        Key[] keys = new Key[size];
        WeakHashMap<Key,Value> map =
                new WeakHashMap<Key, Value>();
        for(int i=0;i<size;i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = k;
            }
            map.put(k,v);
        }
        System.gc();
    }
}










