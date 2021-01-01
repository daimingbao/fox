package cn.supfox.jvm;

import org.openjdk.jol.info.ClassLayout;

public class ObjectHeader {

    public static void main(String[] args) {


        Object o = new Object();

        System.out.println(o);
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());

    }
}
