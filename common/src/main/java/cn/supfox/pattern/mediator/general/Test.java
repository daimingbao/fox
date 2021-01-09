package cn.supfox.pattern.mediator.general;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
        //借助ConcreteMediator 中介平台来发消息，colleageA和colleageB都借助mediator来发消息<br>
        colleagueA.depMethodA();
        System.out.println("-------------------------");
        colleagueB.depMethodB();
    }
}
