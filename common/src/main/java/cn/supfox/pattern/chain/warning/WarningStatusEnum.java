package cn.supfox.pattern.chain.warning;

import lombok.Getter;

@Getter
public enum  WarningStatusEnum {

    PUBLISH(0),
    WAIT_AUDIT(1),
    HANDLE(2),
    RESULT_AUDIT(3);

    private int code;

    WarningStatusEnum(int code) {
        this.code = code;
    }
}
