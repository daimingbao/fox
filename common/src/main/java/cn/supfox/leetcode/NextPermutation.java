package cn.supfox.leetcode;

import org.springframework.util.comparator.Comparators;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 下一个排列 返回比当前数据更大的一个数
 */
public class NextPermutation {

    public static void main(String[] args) {
        // 1 3 5
        // 1 2 5
        // 1 4 5
        // 3 2 5 1 3 4
        int[] nums = new int[]{1,3 ,5};

    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }



        int tmp = nums[1];
        int t2 = nums[1];
        for (int i1 = 1; i1 < nums.length; i1++) {
            if (nums[i1] > tmp ) {
                nums[1] = nums[i1];
                nums[i1] = tmp;
                tmp = nums[1];
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
