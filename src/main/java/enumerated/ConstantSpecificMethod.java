package enumerated;

/**
 * Created by wangqi on 17/2/14.
 */
public enum  ConstantSpecificMethod {
    DATA_TIME {
        String getInfo() {
            return "我是 DATA_TIME";
        }
    },
    CLASSPATH {
        String getInfo() {
            return "我是 classpath";
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod c : values()) {
            System.out.println(c.getInfo());
        }
    }

}
