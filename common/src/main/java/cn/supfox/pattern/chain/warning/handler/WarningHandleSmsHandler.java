package cn.supfox.pattern.chain.warning.handler;

import cn.supfox.pattern.chain.warning.WarningSmsHandlerRequest;
import cn.supfox.pattern.chain.warning.WarningSmsHandlerResult;
import cn.supfox.pattern.chain.warning.WarningStatusEnum;
import org.springframework.stereotype.Component;

/**
 * 处置环节短信发送逻辑
 */
@Component
public class WarningHandleSmsHandler implements SmsHandler {

    @Override
    public boolean support(WarningSmsHandlerRequest request) {
        return request.getNextWarningState().equals(WarningStatusEnum.HANDLE);
    }

    @Override
    public void handleSms(WarningSmsHandlerRequest request, WarningSmsHandlerResult result) {
        //处理审核短信
        System.out.println("处理处置短信发送逻辑");
    }
}
