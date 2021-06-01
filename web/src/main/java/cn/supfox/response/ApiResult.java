package cn.supfox.response;

import lombok.Data;

@Data
public class ApiResult {

    private String code = "000000";

    private String message = "调用成功";
}
