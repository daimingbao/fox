package cn.supfox.algorithm;

import java.util.HashMap;
import java.util.Map;

public class QuickSort {

    public static void main(String[] args) {
       int[] a =  {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
       new QuickSort().findKth(a,  49,24);
        for (int i : a) {
//            System.out.print(i+"---");
        }

        int[] b = {1,2, -99, 5,-5};
        //6;
        int[] ints = twoSum(b, 6);
        System.out.println(ints[0]);

        System.out.println(maxsumofSubarray(b));
    }

    public static int maxsumofSubarray (int[] arr) {
        // write code here
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(max <= max+arr[i]) {
                max = max+arr[i];
            }
        }
        return max;
    }

    public static int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {-1, -1};
        for (int i = 0; i <= numbers.length - 1; i++) {
            int a = target - numbers[i];
            Integer index = map.get(a);
            if (index != null) {
                result[0] = index + 1;
                result[1] = i + 1;
                return result;
            }
            map.put(numbers[i], i);
        }

        return result;
    }

    public  int findKth(int[] a, int n, int K) {
        if(a == null || a.length == 0) {
            return -1;
        }
        // write code here
        sort(a, 0, n-1);
        return a[K-1];
    }

    public void sort(int[] a, int start, int end) {

        if(start >= end ) {
            return ;
        }
        int pivot = a[start];
        int left = start;
        int right = end;
        while(left <= right) {
            while(left <= right && a[left] < pivot ) {
                left++;
            }
            while(left <= right && a[right] > pivot) {
                right--;
            }
            if(left <= right) {
                int temp =  a[left];
                int t2 = a[right];
                a[left] = t2;
                a[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(start+"---"+ end);
        sort(a, start, right);
        sort(a, left, end);
    }
}
