package cn.supfox.algorithm;

/**
 * 计算2的幂
 */
public class Twodeme {

    public static boolean isPowerOfTwo(int n) {

        //递归解法
        if(n == 1 || n == 2) {
            return true;
        }
        boolean result = false;
        if( n%2 == 0) {
            result = isPowerOfTwo(n/2);

        }
        return result;
        // 二进制解法 −n 的二进制表示为 nn 的二进制表示的每一位取反再加上1，比如 n=100 -n=100 因此&之后还是n
        // return (n > 0) && ( n & (-n)) == n;
        //2的幂二进制表示特征 100000。  -1后 变成000001 因此&之后 变成0
        //return (n > 0) && ( n & (n-1)) == 0;
    }

    public static void main(String[] args) {

        boolean powerOfTwo = isPowerOfTwo(512);
        System.out.println(powerOfTwo);
    }
}
