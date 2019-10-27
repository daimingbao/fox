package com.fox.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyBeanPostProcess implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("bean".equalsIgnoreCase(beanName)) {
            log.info("bean [{}] execute postProcessBeforeInitialization", beanName );
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("bean".equalsIgnoreCase(beanName)) {
            log.info("bean [{}] execute postProcessAfterInitialization", beanName );
        }
        return bean;
    }
}
