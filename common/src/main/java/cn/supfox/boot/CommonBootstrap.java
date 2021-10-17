package cn.supfox.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
//        ValidationAutoConfiguration.class,
//        EurekaClientAutoConfiguration.class},
//scanBasePackages = "cn.supfox.rest")
public class CommonBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(CommonBootstrap.class,args);
    }
}
