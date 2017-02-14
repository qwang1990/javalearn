package enumerated;

/**
 * Created by wangqi on 17/2/14.
 */
enum Signal {
    GREEN,
    YELLOW,
    RED
}
public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.YELLOW;
                break;
            default:
                color = Signal.RED;
        }
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0;i<7;i++) {
            System.out.println(t);
            t.change();
        }
    }
}
