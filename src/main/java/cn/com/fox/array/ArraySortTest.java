package cn.com.fox.array;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author dmb
 * @since 2019/8/26
 */
public class ArraySortTest {

    public static void main(String[] args) {

        int[] a = {2,1,0,5,9,6};

        Arrays.sort(a);

        System.out.println(JSON.toJSONString(a));

    }

}
