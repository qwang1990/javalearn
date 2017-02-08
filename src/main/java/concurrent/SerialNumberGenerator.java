package concurrent;

/**
 * Created by wangqi on 17/2/8.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber(){
        return serialNumber++;
    }
}
