package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangqi on 17/2/8.
 */
class NeedsCleanup{
    private final int id;
    public NeedsCleanup(int ident) {
        id = ident;
        System.out.println("need cleanup "+ id);
    }
    public void cleanup() {
        System.out.println("Cleaning up" + id);
    }
}

class Blocked4 implements Runnable {

    private volatile double d =0.0;

    public void run() {
        try {
            while (!Thread.interrupted()){
                NeedsCleanup n1 = new NeedsCleanup(1);
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup n2 = new NeedsCleanup(2);

                    try {
                        System.out.println("Calculating");
                        for(int i =1;i<2500000;i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (InterruptedException e){
            System.out.println("Exiting via InterruptedException");
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
//        if(args.length != 1){
//            System.exit(1);
//        }
        Thread t = new Thread(new Blocked4());
        t.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        t.interrupt();
    }

}
