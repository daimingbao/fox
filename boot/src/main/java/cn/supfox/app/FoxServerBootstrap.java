package cn.supfox.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dmb
 * @since 2019/9/20
 */
@SpringBootApplication(scanBasePackages = {"cn.supfox", "cn.com"})
@MapperScan(basePackages = {"cn.supfox.core.mapper"})
//@EnableEurekaServer
//@EnableFeignClients(basePackages = "cn.com")
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
