package containers;

import java.util.LinkedHashMap;

/**
 * Created by wangqi on 17/2/13.
 * LRU 最近最少使用算法
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<Integer, String>(10,0.75f,true);
        linkedHashMap.put(1,"w");
        linkedHashMap.put(2,"a");
        linkedHashMap.put(3,"n");
        linkedHashMap.put(4,"g");
        linkedHashMap.put(5,"q");

        System.out.println(linkedHashMap);

        linkedHashMap.get(2);
        linkedHashMap.get(4);
        System.out.println(linkedHashMap);
    }
}
