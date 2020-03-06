package cn.com.fox.transaction.service.impl;

import cn.com.fox.transaction.bean.User;
import cn.com.fox.transaction.mapper.UserMapper;
import cn.com.fox.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dmb
 * @since 2020/2/21
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(User user) {
        //OK可怜
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        userMapper.insertSelective(new User());
    }
}
