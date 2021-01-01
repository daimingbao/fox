package cn.supfox;

import java.util.Objects;

public class Static2Test {
    public static void main(String[] args) {

//        String substring = "abba".substring(1, 3);
//        System.out.println(substring.length());
//        System.out.println("haha");

        String s1 = "abbc";
        int length = s1.length();

        int i = 0;
        int j = length-1;
        int n = i;
        int m = j;
        String subStr = "";
        while (i<=j) {

            char c = s1.charAt(i);
            char c1 = s1.charAt(j);
            boolean equals = Objects.equals(c, c1);
            if (!equals){
                i = n+1;
                j = m-1;
                n = i;
                m = j;
            } else {

                if (equals && (i == j || (j-i) ==1 )) {
                    String substring = s1.substring(n, m+1);
                    if (subStr.length() < substring.length()) {
                        subStr = substring;
                    }
                }

                i = i +1;
                j = j-1;
            }


        }
        System.out.println(subStr);
    }
}
