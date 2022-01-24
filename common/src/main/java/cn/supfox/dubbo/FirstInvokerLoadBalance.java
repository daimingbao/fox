package cn.supfox.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.LoadBalance;

import java.util.List;

public class FirstInvokerLoadBalance implements LoadBalance {

    public FirstInvokerLoadBalance() {
        System.out.println("自定义的Dubbo负载均衡器");
    }

    /**
     *
     * @param invokers 所有的提供者信息
     * @param url 服务url，包含配置信息
     * @param invocation 调用器
     * @param <T>
     * @return
     * @throws RpcException
     */
    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        //这里根据自己的需求，选择一个最合适的服务提供者
        Invoker invoker = invokers.get(0);
        //返回第一个提供者
        return invoker;
    }
}
