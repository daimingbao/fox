package cn.supfox.pattern.mediator.rpc;

/**
 * Created by Tom.
 */
public class BService implements IService{
    CService cService;
    AService aService;

    Registy registy;
    BService(){
        registy.regist("bService",this);
    }
}
