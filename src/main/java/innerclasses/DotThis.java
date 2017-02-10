package innerclasses;

/**
 * Created by wangqi on 17/2/10.
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }
    public class Inner {
        public DotThis outer() {
            //如果仅仅是this的话，返回的是inner的this
            return DotThis.this;
        }
    }
    public Inner inner() {
        return new Inner();
    }
    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
        DotThis.Inner dni = dt.new Inner();
    }
}
