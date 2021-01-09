package cn.supfox.pattern.flyweight.jdk.string;

/**
 * Created by Tom.
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";// "hello"是编译器常量， String s1是运行时，把常量地址赋值给他<br>
        String s2 = "hello";
        String s3 = "he" + "llo"; // "he" + "llo" 两个常量相加，会在编译期处理<br>
        String s4 = "hel" + new String("lo"); // "hel" "lo" new String 共建了3个空间，然后拼接起来是一个新的空间（why?）
        String s5 = new String("hello"); // s5存放的是堆中中间
        String s6 = s5.intern();  //拿到常量中的地址，
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8; //为什么这个不一样，因为是变量相加所以编译期没有做优化

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println("s1 " + System.identityHashCode(s1));
        System.out.println("s2 " + System.identityHashCode(s2));
        System.out.println("s3 " + System.identityHashCode(s3));
        System.out.println("s4 " + System.identityHashCode(s4));
        System.out.println("s5 " + System.identityHashCode(s5));
        System.out.println("s6 " + System.identityHashCode(s6)); //s6为s5.intern()拿到的是常量池里的“hello”
        System.out.println("s7 " + System.identityHashCode(s7));
        System.out.println("s8 " + System.identityHashCode(s8));
        System.out.println("s9 " + System.identityHashCode(s9));


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//true
        System.out.println(s1==s4);//false
        System.out.println(s1==s9);//false
        System.out.println(s4==s5);//false
        System.out.println(s1==s6);//true
        System.out.println(s3==s6);//true



    }
}
