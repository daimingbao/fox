package com.supfox.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.simple.annotation.action")
@PropertySource("classpath:/dubbo-consumer.properties")
@ComponentScan(value = {"com.supfox.dubbo"})
public class ConsumerConfiguration {
}
