package cn.supfox.pattern.mediator.general;

// 具体中介者
public class ConcreteMediator extends Mediator {
    @Override
    public void transferA() {
        // 协调行为:A 转发到 B
        //没有直接colleageA调用colleageB，而是通过
        this.colleagueB.selfMethodB();
    }

    @Override
    public void transferB() {
        // 协调行为:B 转发到 A
        this.colleagueA.selfMethodA();
    }
}