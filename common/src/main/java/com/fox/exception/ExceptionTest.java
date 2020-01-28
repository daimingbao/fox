package com.fox.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author dmb
 * @since 2020/1/11
 */
public class ExceptionTest {

    public static void main(String[] args) {
        System.out.println(test());

    }

    public static String test() {
        File f = new File("/Users/daimingbao/code/fox/common/pom.xml");
        try {
            if (f.exists()) {
                new FileInputStream(f);
            }

            return "2";
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
//            System.exit(0);
            return "1";
        }
//        return "";
    }

}
