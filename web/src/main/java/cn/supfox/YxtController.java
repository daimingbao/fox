package cn.supfox;

import cn.supfox.request.YxtCallbackResultRequest;
import cn.supfox.response.ApiResult;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yxt")
public class YxtController {

    @PostMapping(value="sms/callback")
    public ApiResult callback(@RequestBody YxtCallbackResultRequest request) {
        System.out.println("回调结果: " + JSON.toJSONString(request));
        return new ApiResult();
    }
}
