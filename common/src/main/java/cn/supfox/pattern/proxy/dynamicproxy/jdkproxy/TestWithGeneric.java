package cn.supfox.pattern.proxy.dynamicproxy.jdkproxy;

/**
 * Created by Tom.
 */
public class TestWithGeneric {
    public static void main(String[] args) {
        JdkMeipoWithGeneric<IPerson> jdkMeipo = new JdkMeipoWithGeneric<IPerson>();
        //动态代理类是动态生成的，根据客户需求来生成的，动态生成新的类（相当于根据需求来生成）
        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());
        zhangsan.findLove();

        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
        zhaoliu.findLove();

        System.out.println(">>>>>>>>using obj>>>>>>>>>>>>>>>>>");
        JdkMeipo jdkMeipo1 = new JdkMeipo();
        Object zhangsan1 = jdkMeipo1.getInstance(new Zhangsan());
        ((IPerson)zhangsan1).findLove();
    }
}
