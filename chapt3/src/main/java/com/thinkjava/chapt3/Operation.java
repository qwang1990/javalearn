package com.thinkjava.chapt3;

/**
 * Created by wangqi on 16/8/31.
 */
public class Operation {

    public static void testSwitch(String stringCase) {
        switch (stringCase) {
            case "wang":
                System.out.println("hello wang");
                break;
            case "qi":
                System.out.println("hello qi");
                break;
            default:
                System.out.println("hahahahhah");
        }

    }

    public  static void main(String[] args) {

        //在char，byte，short中，使用操作符有提升的效果，所以最这些类型中的任何一个计算都会得到一个int值，
        //若在赋值就需要现实的转换回去
        short a = 1;
        short b = 2;
        short c = (short) (a + b);
        System.out.println(c);

        //溢出不会报错，但是行为无法确定
        int big = Integer.MAX_VALUE;
        int bigger = big + 1;
        System.out.println(bigger);

        testSwitch("wang");
        testSwitch("qi");
        testSwitch("wangqi");

    }
}
