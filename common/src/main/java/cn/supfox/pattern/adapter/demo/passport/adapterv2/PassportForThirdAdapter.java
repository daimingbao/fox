package cn.supfox.pattern.adapter.demo.passport.adapterv2;

import cn.supfox.pattern.adapter.demo.passport.ResultMsg;
import cn.supfox.pattern.adapter.demo.passport.adapterv2.adapters.*;

/**
 * Created by Tom.
 */
public class PassportForThirdAdapter implements IPassportForThird {

    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    public ResultMsg loginForWechat(String openId) {

        return processLogin(openId, LoginForWechatAdapter.class);

    }

    public ResultMsg loginForToken(String token) {

        return processLogin(token, LoginForTokenAdapter.class);
    }

    public ResultMsg loginForTelphone(String phone, String code) {
        return processLogin(phone, LoginForTelAdapter.class);
    }

    /**
     * 不想把LoginForTelAdapter/LoginForTokenAdapter逻辑都写在一个类里所以区分开写<br>
     * @param id
     * @param clazz
     * @return
     */
    private ResultMsg processLogin(String id,Class<? extends ILoginAdapter> clazz){
        try {
            ILoginAdapter adapter = clazz.newInstance();//这个new出来的，我可以从池子里拿到<br>
            if (adapter.support(adapter)){
                return adapter.login(id,adapter);
            }

            /**
             * *************************************************************
             * 已知：
             * 调用login方法时，真正执行的，是特定子类对象，比方说叫objA 的login()方法
             * login()方法的参数，也是为这个特定子类的对象 objA
             * 综合以上两点，不是必然会满足login()实现类中 “obj instanceof 特定子类类型” 这个条件吗？何必多此一举用support()判断呢？
             * *************************************************************
             * 这个看dispatcherSerlet就知道了。<br>
             * TOM 老师思路是仿照Spring框架中怎么用的List<HandlerAdapter> handlerAdapters;然后一个个判断找到合适的adapter</>
             * 如果这里我存的<QQHander,QQHandlerAdapter> <TelHandler,TelHandlerAdatper/>是不是通过遍历然后使用support方法拿到对应的适配器<br>
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
