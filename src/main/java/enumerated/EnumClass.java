package enumerated;

/**
 * Created by wangqi on 17/2/14.
 */
enum Shrubbery {GROUND,CRAWLING,HANGING}
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal: "+s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("------------------------");
        }
    }
}
