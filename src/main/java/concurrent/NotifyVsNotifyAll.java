package concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangqi on 17/2/8.
 */

class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void prod() { notify();}
    synchronized void prodAll() {notifyAll();}
}

class Task implements Runnable {
    static Blocker blocker = new Blocker();
    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable {
    static Blocker blocker = new Blocker();

    public void run() {
        blocker.waitingCall();
    }
}

public class NotifyVsNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i< 5;i++) {
            exec.execute(new Task());
        }
        exec.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if(prod) {
                    System.out.println("notify()");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("notifyAll()");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400 , 400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Time canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2.blocker.prodAll()");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Shutting down");
        exec.shutdown();
    }
}
