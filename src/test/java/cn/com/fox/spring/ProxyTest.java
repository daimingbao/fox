package cn.com.fox.spring;

import cn.com.fox.FoxApplicationTests;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author dmb
 * @since 2019-08-11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bean.class)
@Slf4j
@SpringBootApplication(scanBasePackages = "cn.com.fox", exclude = DataSourceAutoConfiguration.class)
//@ImportAutoConfiguration(classes = {ConfigurationPropertiesAutoConfiguration.class, PropertyPlaceholderAutoConfiguration.class, ProjectInfoAutoConfiguration.class})
public class ProxyTest {

    @Resource
    private ProxyService proxyService;

    @Test
    public void testSpringProxy() {
//        log.info("proxy:{}", proxyService);
        proxyService.proxy();
    }
}
