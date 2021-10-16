package cn.supfox.proxy.service.impl;

import cn.supfox.proxy.service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public void login(String userName) {
        System.out.println("执行登录方法======用户:"+userName+"登录成功");
    }
}
