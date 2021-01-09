package cn.supfox.pattern.proxy.dbroute;

import cn.supfox.pattern.proxy.dbroute.proxy.OrderServiceDynamicProxy;
import cn.supfox.pattern.proxy.dbroute.proxy.OrderServiceStaticProxy;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tom.
 */
public class DbRouteProxyTest {

    @Test
    public void test1(){
        try {
            Order order = new Order();

//            order.setCreateTime(new Date().getTime());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2020/03/01");
            order.setCreateTime(date.getTime());

            IOrderService orderService = (IOrderService)new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void test2()
    {
        try {
            Order order = new Order();

//            order.setCreateTime(new Date().getTime());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2020/03/01");
            order.setCreateTime(date.getTime());

            IOrderService orderService = (IOrderService)new OrderServiceDynamicProxy().getInstance(new OrderService());

            //IOrderService orderService = ()new OrderServiceDynamicProxy().getInstance(new GoodService());

            //1. 订单表分库分表，如果商品表也要分库分表怎么办呢？
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
