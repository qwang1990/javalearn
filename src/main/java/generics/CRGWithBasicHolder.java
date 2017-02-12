package generics;

/**
 * Created by wangqi on 17/2/12.
 * 基类用导出类代替其参数
 * 这就意味着基类变成了一种其所有到处类的公共功能的模板
 */
class Subtype extends BasicHolder<Subtype> {}
public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();
    }
}
