package innerclasses;

/**
 * Created by wangqi on 17/2/10.
 */
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface {

        public void howdy() {
            System.out.println("howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
