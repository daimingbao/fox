package com.fox.eureka.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author dmb
 * @since 2019/9/20
 */
@SpringBootApplication(scanBasePackages = {"cn.supfox", "com.fox"})
@MapperScan(basePackages = {"cn.supfox.transaction.mapper"})
public class FoxServerBootstrap {

//    @EnableAutoConfiguration
//    @EnableEurekaServer
//    public static class EurekaServerConfiguration {
//
//    }


    public static void main(String[] args) {
      new SpringApplicationBuilder(FoxServerBootstrap.class).web(WebApplicationType.SERVLET).run(args);
    }
}
