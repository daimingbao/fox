package com.fox.eureka.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author dmb
 * @since 2019/9/20
 */
@SpringBootApplication
public class EurekaServerBootstrap {

//    @EnableAutoConfiguration
//    @EnableEurekaServer
    public static class EurekaServerConfiguration {

    }


    public static void main(String[] args) {
      new SpringApplicationBuilder(EurekaServerBootstrap.class).web(WebApplicationType.SERVLET).run(args);
    }
}
