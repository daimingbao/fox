package cn.supfox.leetcode;

public class zhengxuzhongweishu {

    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{3});
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m =   nums1.length;
        int n =   nums2.length;

        int total = m + n;
        //
        int centerIndex = (m + n) /2;
        //如果是偶数 比如 4 [length/2,length/2+1]
        //如果是基数 比如 5 (length-1)/2 1 2 3 4 5
        //需要找到第min小的数
        double min = Math.ceil(total / 2);
        double max = (total / 2) + 1;
        boolean o =   (m + n) % 2 == 0;

        //如果是基数，找到第min小的数
        if (!o) {
            int l1 = 0;
            int l2 = 0;
            int minVal = 0;
            int nums = 2;

            int discard = 0;
            while (true) {

                if (discard == min) {
                    //得到第min个数
                }

                int i = nums1[l1];
                int j = nums2[l2];

                if (i < j && l1 < nums1.length - 1) {
                    l1++;
                    nums++;
                    discard ++;
                }
                if (l1 == nums1.length-1) {
                    discard++;
                }
                if (i > j && l2 < nums2.length - 1) {
                    l2++;
                    discard ++;
                }
                if (i == j) {
                    if (l1 < nums1.length - 1) {
                        l1++;
                        discard ++;
                    }
                    if (l2 < nums2.length - 1) {
                        l2++;
                        discard ++;
                    }
                }

            }
        }

        return 0;
    }
}
