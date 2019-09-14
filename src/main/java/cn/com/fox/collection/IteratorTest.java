package cn.com.fox.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author dmb
 * @since 2019/8/25
 */
public class IteratorTest {

    public static void main(String[] args) {

        List<String> abc = new ArrayList<>(3);

        abc.add("a");
        
        abc.add("b");
        abc.add("c");
        for (String a : abc) {
            if ("a".equalsIgnoreCase(a)) {
                abc.remove(a);
            }
        }





        Iterator<String> iterator = abc.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        for (String next : abc) {
            if (next.equals("b") || next.equals("c")) {
//                iterator1.remove();
                abc.remove(next);
                System.out.println(abc);

            }
        }
        System.out.println(abc);
        System.out.println((Object)null);
    }
}
