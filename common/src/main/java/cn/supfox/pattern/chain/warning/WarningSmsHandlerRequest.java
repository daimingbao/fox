package cn.supfox.pattern.chain.warning;

import lombok.Data;

import java.util.List;

@Data
public class WarningSmsHandlerRequest {
    //通报id
    private Long warningId;

    //下一个通报状态
    private WarningStatusEnum nextWarningState;

    //下一个通报处置人类型
    private int warningHandleUnitType;

    //附加参数
    private List<String> attachmentParam;

    //短信模版id 有些短信厂商需要模版
    private String templateId;
}
