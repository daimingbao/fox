package cn.supfox.pattern.chain.warning;

public interface WarningSmsHandlerInvocation {

    WarningSmsHandlerResult invoke(WarningSmsHandlerRequest request);
}
