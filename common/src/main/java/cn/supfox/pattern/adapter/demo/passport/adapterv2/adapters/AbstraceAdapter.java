package cn.supfox.pattern.adapter.demo.passport.adapterv2.adapters;


import cn.supfox.pattern.adapter.demo.passport.PassportService;
import cn.supfox.pattern.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 * 1. 抽象类的话不需要跟着ILoginAdapter修改而修改<br>
 * 2. 这个是框架里比较常见扩展的写法<br>
 * 3. AbstractAdapter 是由后面的LoginForQQAdapter/LoginForTelAdapter公共抽取出来的<br>
 */
public abstract class AbstraceAdapter extends PassportService implements ILoginAdapter {
    protected ResultMsg loginForRegist(String username, String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}
