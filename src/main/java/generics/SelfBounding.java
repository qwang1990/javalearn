package generics;

/**
 * Created by wangqi on 17/2/12.
 * 自限定类型
 * 参数类型必须与正在被定义的类相同
 * 强制泛型作为自己的边界参数
 */
class SelfBounded<T extends SelfBounded<T>>{
    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() {return element;}
}


class A extends SelfBounded<A> {}
class B extends SelfBounded<A> {}
class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}
class D{}
//compile error: type parameter D is not within its bound
//class E extends SelfBounded<D>{}
class F extends SelfBounded {}



public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}
