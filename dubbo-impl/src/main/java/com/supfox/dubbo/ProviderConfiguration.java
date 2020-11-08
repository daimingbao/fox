package com.supfox.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.supfox.dubbo")
@PropertySource("classpath:dubbo.properties")
public class ProviderConfiguration {

}
