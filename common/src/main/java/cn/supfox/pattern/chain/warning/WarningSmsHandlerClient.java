package cn.supfox.pattern.chain.warning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WarningSmsHandlerClient {

    @Autowired
    private WarningSmsHandlerInvocation invocation;

    public void testSmsSend() {

        WarningSmsHandlerRequest request = new WarningSmsHandlerRequest();
        request.setNextWarningState(WarningStatusEnum.WAIT_AUDIT);
        WarningSmsHandlerResult result = invocation.invoke(request);
        System.out.println(result);
    }
}
