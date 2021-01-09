package cn.supfox.pattern.proxy.dynamicproxy.gpproxy.client;


/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        GpMeipo gpMeipo = new GpMeipo();
        /**
         * 体会出透明的感觉，比如spring中你写@Autowire 这个autowire你是可以替换成代理类<br>\
         * 这个代理类你要替换成代码编译没问题不要改，那么就需要代理类要有原始类的api对嘛<br>
         */
        IPerson zhangsan = gpMeipo.getInstance(new Zhangsan());
        zhangsan.findLove();


//        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
//        zhaoliu.findLove();
//        zhaoliu.buyInsure();
    }
}
