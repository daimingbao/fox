package cn.supfox.pattern.mediator.general;

// 抽象中介者，
public abstract class Mediator {
    protected ConcreteColleagueA colleagueA;
    protected ConcreteColleagueB colleagueB;

    public void setColleageA(ConcreteColleagueA colleague) {
        this.colleagueA = colleague;
    }

    public void setColleageB(ConcreteColleagueB colleague) {
        this.colleagueB = colleague;
    }


    // 中介者业务逻辑

    /**
     * 通过中介者来交互，transferA与A交互
     */
    public abstract void transferA();

    public abstract void transferB();
}