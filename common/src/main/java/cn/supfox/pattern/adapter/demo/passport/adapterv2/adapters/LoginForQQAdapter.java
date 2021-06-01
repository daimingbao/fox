package cn.supfox.pattern.adapter.demo.passport.adapterv2.adapters;


import cn.supfox.pattern.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForQQAdapter extends AbstraceAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        if (!support(adapter)) {
            return null;
        }
        //accesseToken  实际工作场景中你是要写很多代码的<br>
        //time
        return super.loginForRegist(id, null);

    }

}
