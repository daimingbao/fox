package com.fox.enums;

import lombok.Getter;

/**
 * @author dmb
 * @since 2020/2/25
 */
@Getter
public enum  StateEnum {

    FAIL(1);

    private int code;

     StateEnum (int code) {
        this.code = code;
    }
}
