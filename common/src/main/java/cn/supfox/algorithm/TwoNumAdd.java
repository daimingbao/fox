package cn.supfox.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class TwoNumAdd {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        //解法1
        int[] ints = twoSum(nums, 26);
        System.out.println(Arrays.toString(ints));



        //解法2 用hash表，把结果存下来
        int target = 6;
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]) ) {
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                System.out.println(map.get(target-nums[i]));
                System.out.println(i );
            }
            map.put(nums[i],i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length-1; i++) {
            for (int j=nums.length-1; j>i; j--) {
                int num = nums[i];
                int num1 = nums[j];
                if (num + num1 == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
