package com.supfox.dubbo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConsumerStarter {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final DubboConsumer dubboService = context.getBean("dubboConsumer", DubboConsumer.class);

        dubboService.testCycleRef();
//        for (int i=1000; i< 2000; i++) {
//            int finalI = i;
//            new Thread(() -> {
//                    dubboService.doConsumer(finalI);
//            }, "测试线程"+i).start();
//
//        }


    }
}
