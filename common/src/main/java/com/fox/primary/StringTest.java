package com.fox.primary;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    public static void main(String[] args) throws InterruptedException {


        String sss = " <p>\n" +
                "                             <h5 class=\"first\"> 企业上市前每月权益池分红</h5>  <br />\n" +
                "                            \uF06C1.各身份对应不同的分红比例对标持有NC的数量进行分红 <br />\n" +
                "                            \uF06C2.享有正式合伙人分红比例1%与所有持有NC的用户分红比例10%<br />\n" +
                "                            \n" +
                "                            <h5 class=\"second\">企业上市后权益</h5><br />\n" +
                "                            \uF06C1.共享有企业上市当年现金利润1%的分红；上市第二年开始3%的永久分红 <br />\n" +
                "                            \uF06C2.1-1000名 共享有企业上市当年现金利润4%的分红；1-1000名 上市第二年开始1%的永久分红 <br />\n" +
                "                            \uF06C3.1-2000名（包含拥有准入资格的合伙人和正式合伙人）共享有企业上市当年现金利润4%的分红；上市第二年开始2%的永久分红 <br />\n" +
                "                            \uF06C根据各自持有NC数量不同，进行分红 <br />\n" +
                "                            \uF06C参与权益池及企业上市分红，持有NC数量不得低于购买礼包时赠送的数量<br />\n" +
                "                            </p>";

        String regEx_html = "<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>"; // 定义HTML标签的正则表达式
        //private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

        for (String a : sss.split("<br />")){
            Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);


            Matcher m_html = p_html.matcher(a);


            a = m_html.replaceAll(""); // 过滤html标签
            System.out.println(a.trim());
        }




        String ss = "d" + "e";
        String s0 = "a";
        String s1 = s0 + "b" +"c";
        String s2 = s0 +"bc";

        System.out.println(s1 == s2);

        String s = null;
        List<String> strings = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            strings.add(new String("hello" +i));


            s += i;
            Thread.sleep(10l);
        }
        long end = System.currentTimeMillis();
        System.out.println(s.getBytes().length);
        System.out.println(end - start);


//
        LockSupport.park();
    }
}
