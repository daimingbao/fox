package cn.supfox.algorithm;

//判断括号是否匹配
public class kuohaopanduan {

    public static void main(String[] args) {

        boolean aaa = aaa("({})");

        System.out.println(aaa);

    }

    public static boolean  aaa(String s) {
        char p1 = '(';
        char p2 = ')';
        char p3 = '[';
        char p4 = ']';
        char p5 = '{';
        char p6 = '}';


        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //循环
            char a = chars[i];
            if (a == p2 || a==p4 || a==p6)  {
                continue;
            }
            for (int j = i + 1; j < chars.length; j++) {
                char b = chars[j];
                if (b == p1 || b==p3 || b==p5)  {
                    continue;
                }
                //匹配到了括号，看下位置是否正确
                boolean khpp = ((a == p1 && b == p2) || (a == p3 && b == p4) || (a == p5 && b == p6));
                if ((j == i + 1) && khpp) {
                    //这个括号已经匹配了，不需要再判断
                    break;
                }
                if(((j-i) % 2) == 0 && khpp) {
                    break;
                }
                return false;
            }

        }

        return true;
    }
}
