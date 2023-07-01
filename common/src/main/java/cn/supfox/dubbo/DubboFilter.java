package cn.supfox.dubbo;

import org.apache.dubbo.rpc.*;

import java.util.UUID;

public class DubboFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        invocation.setAttachment("traceId", UUID.randomUUID().toString());
        // 或者 RpcContext.getContext().setAttachment("traceId", UUID.randomUUID().toString());
        return invoker.invoke(invocation);
    }
}
