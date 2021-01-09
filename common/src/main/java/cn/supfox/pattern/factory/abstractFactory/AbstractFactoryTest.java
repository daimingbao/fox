package cn.supfox.pattern.factory.abstractFactory;

/**
 * Created by Tom.
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {

        JavaCourseFactory factory = new JavaCourseFactory();

        factory.createNote().edit();
        factory.createVideo().record();
//        factory.createQuestion().anwser();
    }

    /**
     * 1. 直接基于factoryMethod代码上把场景更复杂一点，比如一个课程既有视频也有笔记怎么做？自然就能够想到代码怎么写<br>
     * 应用：具体Spring框架中可以参考AbstractBeanFactory.createBean()/getBeanDefinitions();
     * 缺点：如果JavaCourse里面产品族有变化比如增加新的产品那么所有代码都要修改<br>
     */
}
