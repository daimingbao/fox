package cn.supfox.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect //切面aspect
@Configuration
@EnableAspectJAutoProxy
public class TestAspect {

    //切入点 pointcut
    @Pointcut("execution(public * cn.supfox.aop..*(..))")
    public void test(){}

    //通知advice 方法
    @Before("test()")
    public void before() {
        System.out.println("切面");
    }

    //Join point 连接点 某个需要被切入的方法

    //Weaving织入 aspect+advice=advised

    //Introductions 引入 和普通代理不一样，实现新的接口，扩展新方法
    //如下SingerIntroducer
}

//@Aspectpublic
//class SingerIntroducer {
//    @DeclareParents(value="com.mengxiang.concert.Performance+",
//            defaultImpl = BackSinger.class)
//    public static Singer singer;
//}
