package main.java.cn.supfox.openfeign;

import feign.Logger;
import org.apache.cxf.message.Message;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.annotation.Resource;

public class CustomLogger extends Logger {

    @Override
    protected void log(String s, String s1, Object... objects) {

    }
}
