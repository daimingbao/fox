package com.supfox.dubbo;

import org.apache.dubbo.config.annotation.Service;

@Service
public class DubboCycleRegServiceImpl implements DubboCycleRefService {


    @Override
    public void testArg(BeanB beanB) {
        System.out.println(beanB.getBeanA().getBeanB());
        System.out.println(beanB.getBeanA());
        System.out.println(beanB.getBeanA().getBeanB().getBeanA());
        System.out.println(beanB);
    }
}
