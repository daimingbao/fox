package cn.com.fox;

import cn.com.fox.transaction.service.User;
import cn.com.fox.transaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@MapperScan(basePackages = "cn.com.fox.transaction.mapper")
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class TranslationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testReg() {
        User user = new User();
        user.setId(14);
        user.setName("明明");
        userService.register(user);
    }
}
