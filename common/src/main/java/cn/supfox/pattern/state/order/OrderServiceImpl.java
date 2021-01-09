package cn.supfox.pattern.state.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine;
 
    @Autowired
    private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister;
 
    private int id = 1;
    private Map<Integer, Order> orders = new HashMap<>();

    public Order create() {
        Order order = new Order();
        order.setStatus(OrderStatus.WAIT_PAYMENT);
        order.setId(id++);
        orders.put(order.getId(), order);
        return order;
    }

    public Order pay(int id) {
        Order order = orders.get(id);
        String msg = "pay:线程名称：" + Thread.currentThread().getName() + " 尝试支付，订单号：" + id;
        log.info(msg);
        System.out.println(msg);
        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            msg = "线程名称：" + Thread.currentThread().getName() + " 支付失败, 状态异常，订单号：" + id;
            log.info(msg);
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 支付失败, 状态异常，订单号：" + id);
        }
        return orders.get(id);
    }

    public Order deliver(int id) {
        Order order = orders.get(id);
        String msg =  "deliver:线程名称：" + Thread.currentThread().getName() + " 尝试发货，订单号：" + id;
        log.info(msg);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试发货，订单号：" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build(), orders.get(id))) {
            msg = "线程名称：" + Thread.currentThread().getName() + " 发货失败，状态异常，订单号：" + id;
            log.info(msg);
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 发货失败，状态异常，订单号：" + id);
        }
        return orders.get(id);
    }

    public Order receive(int id) {
        Order order = orders.get(id);
        String msg = "receive:线程名称：" + Thread.currentThread().getName() + " 尝试收货，订单号：" + id;
        log.info(msg);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试收货，订单号：" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build(), orders.get(id))) {
            msg = "线程名称：" + Thread.currentThread().getName() + " 收货失败，状态异常，订单号：" + id;
            log.info(msg);
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 收货失败，状态异常，订单号：" + id);
        }
        return orders.get(id);
    }
 

    public Map<Integer, Order> getOrders() {
        return orders;
    }
 
 
    /**
     * 发送订单状态转换事件
     *
     * @param message
     * @param order
     * @return
     */
    private synchronized boolean sendEvent(Message<OrderStatusChangeEvent> message, Order order) {
        boolean result = false;
        try {
            log.info("sendEvent启动状态机！");
            orderStateMachine.start();
            //尝试恢复状态机状态
            log.info("sendEvent恢复状态机！");
            persister.restore(orderStateMachine, order);
            //添加延迟用于线程安全测试
            Thread.sleep(1000);
            log.info("sendEvent-发送事件!");
            result = orderStateMachine.sendEvent(message);
            //持久化状态机状态
            log.info("sendEvent持久化状态机！");
            persister.persist(orderStateMachine, order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            orderStateMachine.stop();
        }
        return result;
    }
}