package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangqi on 17/2/7.
 */
public class SingleThreadExecutor {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i =0;i<5;i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
