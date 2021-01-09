package cn.supfox.pattern.mediator.rpc;

/**
 * Created by Tom.
 */
public class AService implements IService {
    Registy registy;
    AService(){
        //dubbo中这些是通过配置文件写好的<br>
        registy.regist("aService",this);
    }

    public void a(){
        //拉平之后这么玩，类之间没有互相引用，这个可以从配置中心拿不是从代码里写死<br>
        //registy.get("bService").xxx();
    }
}
