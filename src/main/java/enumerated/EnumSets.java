package enumerated;

import java.util.EnumSet;
import static enumerated.AlarmPoints.*;

/**
 * Created by wangqi on 17/2/14.
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(STAIR1);
        System.out.println(points);
        points.addAll(EnumSet.of(STAIR1,STAIR2,OFFICE3));
        System.out.println(points);
        points.removeAll(EnumSet.of(STAIR1,STAIR2));
        System.out.println(points);
    }
}
