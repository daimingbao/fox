package cn.supfox.pattern.adapter.demo.passport.adapterv1;


import cn.supfox.pattern.adapter.demo.passport.PassportService;
import cn.supfox.pattern.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 * 1. 这里采用继承的方式，也可以采用组合的方式<br>
 * 2. 如果以后加了抖音登录的方式就要修改这个类<br>
 */
public class PassportForThirdAdapter extends PassportService implements IPassportForThird {

    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId,null);
    }

    public ResultMsg loginForWechat(String openId) {
        return loginForRegist(openId,null);
    }

    public ResultMsg loginForToken(String token) {
        return loginForRegist(token,null);
    }

    public ResultMsg loginForTelphone(String phone, String code) {
        return loginForRegist(phone,null);
    }

    private ResultMsg loginForRegist(String username,String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}
