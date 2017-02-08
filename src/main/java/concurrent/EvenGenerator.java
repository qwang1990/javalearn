package concurrent;

/**
 * Created by wangqi on 17/2/7.
 */
public class EvenGenerator extends IntGenerator {
    private int curentEvenValue = 0;

    public int next() {
        ++curentEvenValue;
        ++curentEvenValue;
        return curentEvenValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }

}
