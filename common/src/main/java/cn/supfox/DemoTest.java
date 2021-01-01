package cn.supfox;

import java.io.IOException;
import java.util.*;

public class DemoTest {

    public class ListNode {
        int val; ListNode next; ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println((Integer.MAX_VALUE +100));
//        int[] agess = new int[]{-3,-2,-5,3,-4};
//        int i = threeSumClosest(agess, -1);
//        System.out.println(i);
//        System.in.read();



    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1,head);


        ListNode l1 = dummy.next;

        ListNode l2 = dummy.next.next;

        while (l2 != null) {
            ListNode l3 = l2.next;
            l1.next = l3;
            l2.next = l1;
        }

        return dummy.next;
    }


    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int r = 10000;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //第一个数
            int first = nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int third = nums[start];
                int result = first + nums[end] + third;
                if (result == target) {
                    return target;
                }
                //差值越小，越接近
                if (Math.abs(result - target) < Math.abs(r - target)) {
                    r = result;
                }

                // 如果和大于 target，移动 c 对应的指针
                if (result > target) {
                    int k0 = end - 1;
                    // 移动到下一个不相等的元素
                    while (start < k0 && nums[k0] == nums[end]) {
                        --k0;
                    }
                    end = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = start + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < end && nums[j0] == nums[start]) {
                        ++j0;
                    }
                    start = j0;
                }
            }
        }
            return r;

        }

        public static List<List<Integer>> longestCommonPrefix ( int[] nums){

            if (nums == null || nums.length < 3) {
                return new ArrayList<>();
            }
            Set<String> set = new HashSet<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return getLists(set);
                }
                //第一个数
                int first = nums[i];
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int third = nums[start];
                    int result = first + nums[end] + third;
                    if (result == 0) {
                        System.out.println(1);
                        System.out.println(first + "#" + nums[end] + "#" + third);
                        set.add(first + "#" + nums[end] + "#" + third);
                        start++;
                        end--;
                    }
                    if (result < 0) {
                        start++;
                    }
                    if (result > 0) {
                        end--;
                    }
                }
            }

            List<List<Integer>> list = getLists(set);
            return list;
        }

        private static List<List<Integer>> getLists (Set < String > set) {
            List<List<Integer>> list = new ArrayList<>();
            for (String s : set) {
                String[] split = s.split("#");
                List<Integer> l = new ArrayList<>();
                for (int i = 0; i < split.length; i++) {
                    l.add(Integer.valueOf(split[i]));
                }
                list.add(l);
            }
            return list;
        }
    }
