package concurrent;

/**
 * Created by wangqi on 17/2/7.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() { canceled = true; }
    public boolean isCanceled(){ return canceled; }
}
