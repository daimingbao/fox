package cn.supfox.pattern.chain.warning.handler;

import cn.supfox.pattern.chain.warning.WarningSmsHandlerRequest;
import cn.supfox.pattern.chain.warning.WarningSmsHandlerResult;

/**
 * 短信处理器接口
 */
public interface SmsHandler {

    //当前接口是否支持处理
    boolean support(WarningSmsHandlerRequest request);

    //处理逻辑
    void handleSms(WarningSmsHandlerRequest request, WarningSmsHandlerResult result);
}
