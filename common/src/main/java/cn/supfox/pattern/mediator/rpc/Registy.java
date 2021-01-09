package cn.supfox.pattern.mediator.rpc;

/**
 *
 * //RPC    Remote Procedure Call  远程过程调用
 *
 * 伪代码
 * Created by Tom.
 */
public class Registy {
    //通过中介者缩短调用链
    //服务治理
    public boolean regist(String serviceName,IService service){
        return true;
    }

    public IService get(String serviceName){
        return null;
    }

    //通过Registy拉平而不是互相引用，
    //用的时候，通过registy.
}
