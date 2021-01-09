package cn.supfox.pattern.factory.factoryMethod;

import org.junit.Test;

/**
 * Created by Tom.
 */
public class FactoryMethodTest {

    @Test
    public void test1() {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();
    }

    /**
     * 从简单工厂到工厂方法，工厂方法是为了解决什么问题？我想知道了简单工厂的问题所在从而工厂方法解决了什么问题自然就能够写出代码，不要死记<br>
     * 比如Log4j里ILoggerFactory里就有很多具体的工厂实现类<br>
     * 缺点：如果来了个AI那么就有AICourseFactory造成类的数目过多。
     */
}
