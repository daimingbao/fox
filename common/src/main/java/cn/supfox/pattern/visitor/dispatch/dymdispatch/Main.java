package cn.supfox.pattern.visitor.dispatch.dymdispatch;

/**
 * Created by Tom.
 */
public class Main {
    public static void main(String[] args) {
        Person man = new Man();
        Person woman = new WoMan();

        //把对象new出来找到 具体类型动态分配，每次根据一个类型分配而不是根据多个类型分配
        man.test();
        woman.test();
    }
}
