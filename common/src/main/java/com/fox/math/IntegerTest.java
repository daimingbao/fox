package com.fox.math;

/**
 * @author dmb
 * @since 2019/9/19
 */
public class IntegerTest {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE -100;
        int b= Integer.MAX_VALUE;
        int count = 0;
        for (int i =a ; i<=b; i++) {
            count++;
        }
        System.out.println(count);
    }
}
