package cn.supfox.pattern.iterator.jdkdemo;

import java.util.*;

public class Test {
    @org.junit.Test
    public void testList(){
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        Iterator it = list1.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }

    @org.junit.Test
    public void testMap(){
        Map<String,String> map1 = new HashMap<>();
        map1.put("a","a");
        map1.put("b","b");
        map1.put("c","c");
        map1.put("d","d");

        System.out.println("a:" + map1.get("a"));
    }
}
