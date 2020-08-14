package cn.supfox.algorithm.loadbalance;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");

        Stream.of(allByName).forEach(System.out::println);
        System.out.println();

        // 负载均衡
        //client side 客户端负载均衡  随机 轮训
        //server side 服务端负载均衡
        //软/硬件负载均衡 dns


    }
}
