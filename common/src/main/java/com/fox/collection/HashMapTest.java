package com.fox.collection;

/**
 * @author dmb
 * @since 2019/12/6
 */
public class HashMapTest {

    public static void main(String[] args) {

        //2^4=16  2^5=32   2^6= 1111 1111
        int index = 100 & 15 ;
        System.out.println(index);
        index = 100 & 31;
        System.out.println(index);
        index = 100 & 63;
        System.out.println(index);


    }

}
