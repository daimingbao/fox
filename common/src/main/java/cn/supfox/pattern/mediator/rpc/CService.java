package cn.supfox.pattern.mediator.rpc;

/**
 * Created by Tom.
 */
public class CService implements IService {
    BService bservice;
    AService aService;

    /**
     * 原来的<br>
     */
    public void c()
    {
        //bservice.call()
        //aservcice.call()
    }

    Registy registy;
    CService(){
        registy.regist("cService",this);
    }


}
