package com.fox.sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序，两次循环，
 * 第一次循环：循环数组大小对应的次数
 * 第二次循环：相临两个数比较并交换，得到第i小的数
 * 时间复杂度：本身是有序的序的，最好O(n)
 * @author dmb
 * @since 2019/9/6
 */
public class BubbleSort {

    public static void main(String[] args) {


        Integer[] nums = {3,6,9,1,2};

        for (int i=0; i< nums.length; i++) {
            for (int j=0; j< nums.length-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        System.out.println( JSON.toJSONString(nums));

    }

}
