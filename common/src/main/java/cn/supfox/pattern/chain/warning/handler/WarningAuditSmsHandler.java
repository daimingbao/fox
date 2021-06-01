package cn.supfox.pattern.chain.warning.handler;

import cn.supfox.pattern.chain.warning.WarningSmsHandlerRequest;
import cn.supfox.pattern.chain.warning.WarningSmsHandlerResult;
import cn.supfox.pattern.chain.warning.WarningStatusEnum;
import org.springframework.stereotype.Component;

/**
 * 审核环节短信发送逻辑
 */
@Component
public class WarningAuditSmsHandler implements SmsHandler {
    @Override
    public boolean support(WarningSmsHandlerRequest request) {
        return request.getNextWarningState().equals(WarningStatusEnum.WAIT_AUDIT);
    }

    @Override
    public void handleSms(WarningSmsHandlerRequest request, WarningSmsHandlerResult result) {
        //处理审核短信
        System.out.println("处理审核短信发送逻辑");
    }
}
