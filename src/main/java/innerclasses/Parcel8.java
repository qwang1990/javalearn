package innerclasses;

/**
 * Created by wangqi on 17/2/10.
 */
public class Parcel8 {
    public Wrapping wrapping(int x) {
        //构建基类需要参数的
        return new Wrapping(x){
            @Override
            public int value() {
                return super.value()*47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p =new Parcel8();
        Wrapping w = p.wrapping(10);
    }
}
