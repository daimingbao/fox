package cn.supfox.pattern.proxy.general;

/**
 * Created by Tom.
 */
public class Proxy implements ISubject {

    private ISubject subject;

    public Proxy(ISubject subject){
        this.subject = subject;
    }

    /**
     * 代码增强
     */
    public void request() {
        before();
        subject.request();
        after();
    }

    public void before(){
        System.out.println("called before request().");
    }

    public void after(){
        System.out.println("called after request().");
    }
}
