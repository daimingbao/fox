package cn.com.fox.transaction.service;


import cn.com.fox.transaction.ExecuteSegment;
import cn.com.fox.transaction.MyThreadLocal;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class MyAop {

    public void init() {
        System.out.println("初始化");
    }


    // 可以被重复利用
    @Pointcut(value = "execution(public * cn.com.fox.transaction.service..*.*(..))")
    private void pointcut() {}

    // 前置通知
    // value值：需要设置一个切入点表达式，将连接点(目标方法)找到，在连接点上执行前置通知。
    // @Before(value="execution(* *.*(..))")
    @Before(value = "pointcut() && @annotation(executeSegment)")
    public void startLog(JoinPoint joinPoint, ExecuteSegment executeSegment) {

        // 通过JoinPoint(切入点对象)获取方法参数列表 为数组
        Object[] args = joinPoint.getArgs();
        // 将数组转化为集合
        List<Object> asList = Arrays.asList(args);

        // 通过JoinPoint(切入点对象)获取方法对象
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();


        System. out.println("[☆日志][" + methodName + "方法开始][参数值：" + asList + "]");

        System.out.println(MyThreadLocal.get());
    }

    // 最终通知（后置通知）
    @After(value = "pointcut() && @annotation(executeSegment) ")
    public void finallyLog(JoinPoint joinPoint, ExecuteSegment executeSegment) {

        Object[] args = joinPoint.getArgs();
        List<Object> asList = Arrays.asList(args);

        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System. out.println("[☆日志][" + methodName + "方法最终执行][参数值：" + asList + "]");
    }

}
