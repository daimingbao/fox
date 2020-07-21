package cn.supfox.itorator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author dmb
 * @since 2019/12/4
 */
public class IteratorTest {

   static List<Integer> list = new ArrayList<>();
    static {
        for (int i=0; i<20000; i++) {
            list.add(i);
        }
    }


    public static void main(String[] args) {
        Iterator<Integer> iterator;
        long start = System.currentTimeMillis();
        for (int a : list) {
//            System.out.println("2");
            int b =a;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        iterator = list.iterator();
        start = System.currentTimeMillis();
        while (iterator.hasNext()) {

            iterator.next();
        }
        end = System.currentTimeMillis();
        System.out.println(end -start);
    }

}
