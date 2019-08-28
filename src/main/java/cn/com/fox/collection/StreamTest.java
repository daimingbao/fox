package cn.com.fox.collection;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * @author dmb
 * @since 2019/8/26
 */
public class StreamTest {

    public static void main(String[] args) {

        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(2);

        IntSummaryStatistics collect = list.stream().mapToInt(value -> value).collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine);
        System.out.println(JSON.toJSONString(collect));
    }
}
