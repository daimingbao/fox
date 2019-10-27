package com.fox.collection;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dmb
 * @since 2019/8/26
 */
public class StreamTest {

    public static void main(String[] args) {

        testFlatMap();

        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(2);

        IntSummaryStatistics collect = list.stream().mapToInt(value -> value).collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine);
        System.out.println(JSON.toJSONString(collect));
    }

    public static void testFlatMap() {
        String[] str = {"abc", "bcd"};
        List<String[]> collect = Stream.of(str).map(a -> a.split("")).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        List<String> collect1 = Stream.of(str).map(a -> a.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collect1);

    }
}
