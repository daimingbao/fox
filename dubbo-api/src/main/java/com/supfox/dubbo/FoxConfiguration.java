package com.supfox.dubbo;

import org.springframework.context.annotation.Bean;

@FoxDubbo
public class FoxConfiguration {

    @Bean
    public BeanA beanTest() {
        return new BeanA();
    }

}
