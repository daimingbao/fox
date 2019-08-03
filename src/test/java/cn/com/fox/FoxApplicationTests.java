package cn.com.fox;

import cn.com.fox.spring.Bean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bean.class)
@Slf4j
@SpringBootApplication(scanBasePackages = "cn.com.fox", exclude = DataSourceAutoConfiguration.class)
public class FoxApplicationTests {

	@Resource
	private ApplicationContext applicationContext;

	@Test
	public void contextLoads() throws IOException {
		log.info("#########------------spring boot test start-------------#######");
		Bean bean = applicationContext.getBean("bean", Bean.class);
//		System.in.read();
	}
}
