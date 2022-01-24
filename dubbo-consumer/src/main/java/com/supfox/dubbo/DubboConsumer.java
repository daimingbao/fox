package com.supfox.dubbo;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class DubboConsumer {

    @Reference(check = false)
    private DubboService dubboService;

    @Reference(loadbalance = "firstInvoker")
    private DubboCycleRefService dubboCycleRefService;


    public void testCycleRef() {
        BeanB beanB = new BeanB();
        beanB.setName("你好");
        BeanA beanA = new BeanA();
        beanB.setBeanA(beanA);
        beanA.setBeanB(beanB);
        dubboCycleRefService.testArg(beanB);
    }

    public void doConsumer(int i) {
        String test = dubboService.test();
        System.out.println("调用"+ i +"结果" + test);
    }


}
