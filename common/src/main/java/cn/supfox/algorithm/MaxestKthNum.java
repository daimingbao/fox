package cn.supfox.algorithm;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 */
public class MaxestKthNum {

    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{3, 2, 1, 5, 6, 4
        }, 2);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            //先拿到第一个大的，放到第一个元素位置
            for (int j = i; j < nums.length; j++) {
                int max = nums[i];
                int tmp = nums[j];
                if (tmp > max) {
                    nums[j] = max;
                    nums[i] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];

    }
}
