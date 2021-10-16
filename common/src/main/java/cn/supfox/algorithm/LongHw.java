package cn.supfox.algorithm;

public class LongHw {


    public static void main(String[] args) {


        String str = "adda";
        boolean a = str.charAt(1) == '-';

        System.out.println(ishuiwen(str));

    }

    public static boolean ishuiwen(String str){
        boolean isHuiWen=true;
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                isHuiWen=false;
                break;
            }
        }
        return isHuiWen;
    }
}
