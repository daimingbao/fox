package cn.supfox.config;

import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) {

        //获取系统属性 包括用户系统版本，类型，用户工作目录，用户名，jdk版本等
        Properties properties = System.getProperties();
        System.out.println(JSON.toJSONString(properties));

        //获取系统环境变量，包括path路径，应用主类
        Map<String, String> getenv = System.getenv();
        System.out.println(JSON.toJSONString(getenv));
    }
}
