package cn.supfox.app;

import cn.supfox.core.db.User;
import cn.supfox.core.service.UserService;
import cn.supfox.pattern.chain.warning.WarningSmsHandlerClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

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

//    @Autowired
//    private WarningSmsHandlerClient warningSmsHandlerClient;


    public static void main(String[] args) {

        ApplicationContext app = new SpringApplicationBuilder(FoxServerBootstrap.class).web(WebApplicationType.SERVLET).run(args);

        UserService userService = app.getBean(UserService.class);
//        userService.register(new User());
//        userService.register(new User());
//        WarningSmsHandlerClient warningSmsHandlerClient = app.getBean(WarningSmsHandlerClient.class);
//
//        warningSmsHandlerClient.testSmsSend();
    }
}
