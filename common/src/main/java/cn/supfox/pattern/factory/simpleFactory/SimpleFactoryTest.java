package cn.supfox.pattern.factory.simpleFactory;

import org.junit.Test;

/**
 * 小作坊式的工厂模型
 * Created by Tom.
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

//        ICourse course = new JavaCourse();
//        course.record();

//        ICourseFactory factory = new ICourseFactory();
//        ICourse course = factory.create("com.gupaoedu.vip.pattern.factory.JavaCourse");
//        course.record();

        CourseFactory factory = new CourseFactory();
        // 如果不用工厂，客户端会变得非常臃肿<br>
        ICourse course = factory.create(JavaCourse.class);
        course.record();
    }

    /**
     * 没用工厂模式
     */
    @Test
    public void test1()
    {
        ICourse course = new JavaCourse();
        course.record();
    }

    /**
     * 1. 如果用这个有什么优点：如果你这是一个单独的文件，我都不需要Import JavaCourse这个类<br>
     * 2. courseFactory.create("java") 参数"java" 可以是从参数或者配置中传过来
     * 你们能够体会到这个好处嘛？
     */
    @Test
    public void testSimpleFactory1()
    {
        CourseFactory courseFactory = new CourseFactory();
        //传入参数，参数意思是什么根据逻辑来定义
        ICourse  course = courseFactory.create("java");
        course.record();
    }

    @Test
    public void testSimpleFactory2()
    {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.createWithClassName("com.gupaoedu.vip.pattern.factory.JavaCourse");
        course.record();
    }

    @Test
    public void testSimpleFactory3()
    {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create(JavaCourse.class);
        course.record();
    }

    /**
     * 这里虽然是简单工程，回想一下如果你用简单工厂跟不用工厂有什么不一样，能够体会到好处嘛？
     *
     */
}
