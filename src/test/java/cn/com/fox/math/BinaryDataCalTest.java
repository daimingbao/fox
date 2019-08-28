package cn.com.fox.math;

import org.apache.commons.lang3.StringUtils;

/**
 * @author dmb
 * @since 2019-08-24
 */
public class BinaryDataCalTest {

    public static void main(String[] args) {

        int i =1;

        String s = Integer.toBinaryString(i);
        if (s.length() < 8) {
             s = StringUtils.leftPad(s, 8, "0");
        }
        System.out.println(s);
    }
}
