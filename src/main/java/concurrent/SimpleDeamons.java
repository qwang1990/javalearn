package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangqi on 17/2/7.
 */
public class SimpleDeamons implements Runnable {

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i< 10; i++){
            Thread deamon = new Thread(new SimpleDeamons());
            deamon.setDaemon(true);
            deamon.start();
        }
        System.out.println("All deamons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
