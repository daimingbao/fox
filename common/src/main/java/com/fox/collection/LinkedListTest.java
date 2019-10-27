package com.fox.collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dmb
 * @since 2019/8/25
 */
public class LinkedListTest {
    public static void main(String[] args) {

        Deque<String> list = new LinkedList<>();
        boolean add = list.add(null);
        String next = list.iterator().next();
        list.add(null);
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getFirst());

    }
}
