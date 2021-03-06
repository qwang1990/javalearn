package concurrent;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by wangqi on 17/2/7.
 */

class TaskWithResult implements Callable<String> {

    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call() throws Exception {
        return "result of TaskWithResult "+ id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<Future<String>>();
        for(int i = 0; i< 10; i++)
            result.add(exec.submit(new TaskWithResult(i)));

        for(Future<String> fs:result)
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }

    }
}
