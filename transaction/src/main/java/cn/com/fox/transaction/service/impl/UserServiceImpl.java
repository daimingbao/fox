package cn.com.fox.transaction.service.impl;

import cn.com.fox.transaction.bean.User;
import cn.com.fox.transaction.mapper.UserMapper;
import cn.com.fox.transaction.service.OrderService;
import cn.com.fox.transaction.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author dmb
 * @since 2020/2/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderService orderService;

    @Override
    public void delete(User user) {

    }

    @Override
    @Transactional(readOnly = false)
    public void add(User user) {

        userMapper.insertSelective(user);
        System.out.println("你好");
        System.out.println(this);
        System.out.println(AopContext.currentProxy());
        delete(user);
//        orderService.add(null);

//        throw new RuntimeException("入库错误");
    }
}
