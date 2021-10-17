package cn.supfox.pattern.state.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Tom.
 * 给你自定义过程：这个状态下有哪些行为，这个状态的下一个状态是什么？
 */
//@SpringBootApplication
public class Test {
    static Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");

        ConfigurableApplicationContext context = SpringApplication.run(Test.class,args);

        IOrderService orderService = (IOrderService)context.getBean("orderService");

        orderService.create();
        orderService.create();

        orderService.pay(1);

        new Thread("客户线程"){
            @Override
            public void run() {
                orderService.deliver(1);
                orderService.receive(1);
            }
        }.start();

        orderService.pay(2);
        orderService.deliver(2);
        orderService.receive(2);
        log.info("全部订单状态：" + orderService.getOrders());

        /**
         * 订单1的状态流转变化：可以看到是先由主线程执行后面由客户线程执行<br>
         * 2021-01-08 16:11:27.819  INFO 27640 --- [            主线程] c.g.v.d.p.state.order.OrderServiceImpl   : pay:线程名称：主线程 尝试支付，订单号：1
         * pay:线程名称：主线程 尝试支付，订单号：1
         * 支付，状态机反馈信息：{order=订单号：1, 订单状态：WAIT_DELIVER, id=68d6b05d-350d-634e-8ea5-f771626866c2, timestamp=1610093487830}
         * 2021-01-08 16:11:28.846  INFO 27640 --- [           客户线程] c.g.v.d.p.state.order.OrderServiceImpl   : deliver:线程名称：客户线程 尝试发货，订单号：1
         * 线程名称：客户线程 尝试发货，订单号：1
         * 发货，状态机反馈信息：{order=订单号：1, 订单状态：WAIT_RECEIVE, id=42a3c1dd-a97e-81ed-4a5c-39a6237c8505, timestamp=1610093488847}
         * 2021-01-08 16:11:30.863  INFO 27640 --- [           客户线程] c.g.v.d.p.state.order.OrderServiceImpl   : receive:线程名称：客户线程 尝试收货，订单号：1
         * 线程名称：客户线程 尝试收货，订单号：1
         * 收货，状态机反馈信息：{order=订单号：1, 订单状态：FINISH, id=e8cd15d5-f87e-b51f-3ec2-48ca59cfeb42, timestamp=1610093490863}
         * 2021-01-08 16:11:33.879  INFO 27640 --- [            主线程] c.g.vip.design.pattern.state.order.Test  : 全部订单状态：{1=订单号：1, 订单状态：FINISH, 2=订单号：2, 订单状态：FINISH}
         */
    }
}
