package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangqi on 17/2/8.
 */
class BlockedMutexx {
    private Lock lock = new ReentrantLock();

    public void f(){
            lock.lock();
            g();
            System.out.println("lock acquired in f()");
            lock.unlock();
    }

    public void g(){
        lock.lock();
        System.out.println("lock acquired in g()");
        lock.unlock();
    }
}

class Blocked3 implements Runnable {
    BlockedMutexx blocked = new BlockedMutexx();

    public void run() {
        System.out.println("waiting for f() int BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }
}

public class Interrupting3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.SECONDS.sleep(1);
      //  System.out.println("Issuing t.interrupt()");
     //   t.interrupt();
    }
}
