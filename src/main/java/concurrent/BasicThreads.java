package concurrent;

/**
 * Created by wangqi on 17/2/7.
 */
public class BasicThreads {
    public static void main(String[] args) {
        for(int i=0;i < 5;i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
