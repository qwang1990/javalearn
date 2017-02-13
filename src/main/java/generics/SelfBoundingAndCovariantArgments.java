package generics;

/**
 * Created by wangqi on 17/2/13.
 */
interface SelfBoundSetter<T > {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {

}

public class SelfBoundingAndCovariantArgments {

//    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
//        s1.set(s2);
//        s1.set(sbs);
//    }

    void testFruit() {
        Orange1 o1 = new Orange1();
        Orange1 o2 = new Orange1();
        Apple1 a1 = new Apple1();
        Apple1 a2 = new Apple1();

        a1.add(a2);
       // a1.add(o1);
    }

}

// interface Fruit1<T extends Fruit1<T>> {
interface Fruit1<T> {
    void add(Fruit1<T> t);
}

class Orange1 implements Fruit1<Orange1> {
    public void add(Fruit1<Orange1>  orange) {
        System.out.println("orange");
    }
}

class Apple1 implements Fruit1<Apple1> {
    public void add(Fruit1<Apple1>  apple1) {
        System.out.println("apple1");
    }
}

