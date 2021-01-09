package cn.supfox.pattern.strategy.general;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        //选择一个具体策略
        IStrategy strategy = new ConcreteStrategyA();
        //来一个上下文环境，
        /**
         * 算法（你可以参数传过来也可以变成成员变量所以是有多种写法）<br>
         * 就怕有的学生拿着那个代码结构去套，看到这个是成员变量以为不是策略模式，因为是策略所以方式可以被替换<br>
         */

        Context context = new Context(strategy);
        //客户端直接让上下文环境执行算法
        context.algorithm();
    }
}
