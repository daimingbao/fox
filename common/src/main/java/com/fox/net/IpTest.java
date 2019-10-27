package com.fox.net;

import com.alibaba.fastjson.JSON;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author dmb
 * @since 2019/9/18
 */
public class IpTest {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        System.out.println(JSON.toJSONString(allByName));
    }
}
