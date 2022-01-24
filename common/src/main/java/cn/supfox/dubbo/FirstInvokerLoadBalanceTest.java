package cn.supfox.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.cluster.LoadBalance;

public class FirstInvokerLoadBalanceTest {

    public static void main(String[] args) {
        LoadBalance firstInvoker = ExtensionLoader.getExtensionLoader(LoadBalance.class)
                .getExtension("firstInvoker");
        System.out.println("打印自定义负载均衡器类："+firstInvoker.getClass());
    }
}
