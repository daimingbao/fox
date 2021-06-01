package cn.supfox.pattern.chain.warning;

import cn.supfox.pattern.chain.warning.handler.SmsHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
public class WarningSmsHandlerInvocationImpl implements WarningSmsHandlerInvocation {

    @Autowired
    private List<SmsHandler> smsHandlers;

    @Override
    public WarningSmsHandlerResult invoke(WarningSmsHandlerRequest request) {
        WarningSmsHandlerResult result = new WarningSmsHandlerResult();
        for (SmsHandler smsHandler : smsHandlers) {
            if (smsHandler.support(request)) {
                smsHandler.handleSms(request, result);
            }
        }
        return result;
    }
}
