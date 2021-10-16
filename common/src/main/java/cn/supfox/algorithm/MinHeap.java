package cn.supfox.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        queue.add(5);
        queue.add(1);

        int k = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< k; i++) {
            list.add(queue.poll());
        }

        System.out.println(queue.poll());

    }
}
