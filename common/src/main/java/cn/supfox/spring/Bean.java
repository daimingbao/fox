package cn.supfox.spring;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
@Setter
public class Bean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String beanName;

    @PostConstruct
    public void init() {
        log.info("init [bean] start");
    }

    public Bean() {
        log.info("bean [bean] construct init start");
    }

    @Override
    public void setBeanName(String beanName) {
        log.info("bean [{}] set bean name",this.beanName = beanName);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("bean [{}] set beanFactory {} ", this.beanName, beanFactory.getClass().getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("bean [{}] set applicationContext {} ", this.beanName, applicationContext.getApplicationName());

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("bean [{}] afterPropertiesSet {} ", this.beanName);

        log.info("bean [{}] start using...", this.beanName);

    }

    @Override
    public void destroy() throws Exception {
        log.info("destroy [bean] start");
    }
}
