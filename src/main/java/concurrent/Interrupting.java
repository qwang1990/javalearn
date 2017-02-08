package concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangqi on 17/2/8.
 */

/**
 * sleep是可中断阻塞
 */
class SleepBlocked implements Runnable {

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}

/**
 * 不可中断阻塞
 */
class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream is) {in = is;}
    public void run() {
        try {
            System.out.println("Waiting for read():");
            in.read();
        } catch (IOException e) {
            if(Thread.currentThread().isInterrupted()){
                System.out.println("interrupted");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocking.run()");
    }
}

/**
 * 不可中断阻塞
 */
class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        while (true)
            Thread.yield();
    }

    public SynchronizedBlocked(){
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt send to "+ r.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");

        exec.shutdownNow(); //依然停不掉后两个
        System.exit(0);
    }
}