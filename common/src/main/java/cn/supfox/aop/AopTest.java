package cn.supfox.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.core.io.ClassPathResource;


@Aspect
//@Configuration
public class AopTest {


    @Pointcut("execution(public * cn.supfox.aop..*(..))")
    public void test() {
    }

    @Before("test()")
    public void before() {
        System.out.println("切面");
    }


    public static void main(String[] args) {

//        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext("cn.supfox.aop");

//        AopConfigUtils.registerAutoProxyCreatorIfNecessary(app.getDefaultListableBeanFactory());
//        app.getBeanFactory().addBeanPostProcessor(new AspectJAwareAdvisorAutoProxyCreator());
//        app.registerBean(AspectJAwareAdvisorAutoProxyCreator.class);
//        app.registerBean(AnnotationAwareAspectJAutoProxyCreator.class);
//        BeanDefinition bd = new RootBeanDefinition(AnnotationAwareAspectJAutoProxyCreator.class);
//        app.registerBeanDefinition("annotationAwareAspectJAutoProxyCreator",bd);
//
//       BizService bizService = app.getBean(BizService.class);
//       bizService.doBiz();


        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        new XmlBeanDefinitionReader(factory).loadBeanDefinitions(
                new ClassPathResource("/aspectj-autoproxy-config.xml", AopTest.class));
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(factory);
        ctx.addBeanFactoryPostProcessor(new ConfigurationClassPostProcessor());
        ctx.registerBeanDefinition("config", new RootBeanDefinition(cn.supfox.aop.AopTest.class));
        ctx.scan("cn.supfox.aop");
        ctx.refresh();


        BizService bizService = ctx.getBean(BizService.class);
        bizService.doBiz();

//        TestBean testBean = ctx.getBean("testBean", TestBean.class);
//        assertThat(testBean.getName(), equalTo("name"));
//        testBean.absquatulate();
//        assertThat(testBean.getName(), equalTo("advisedName"));


    }

}