package cn.supfox.pattern.adapter.demo.passport.adapterv2.adapters;


import cn.supfox.pattern.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForWechatAdapter extends AbstraceAdapter{
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegist(id,null);
    }


}