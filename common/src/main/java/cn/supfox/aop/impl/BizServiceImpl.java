package cn.supfox.aop.impl;

import cn.supfox.aop.BizService;
import org.springframework.stereotype.Service;

@Service
public class BizServiceImpl implements BizService {
    @Override
    public void doBiz() {
        System.out.println("业务逻辑");
    }
}