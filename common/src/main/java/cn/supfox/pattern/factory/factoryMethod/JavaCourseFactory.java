package cn.supfox.pattern.factory.factoryMethod;

/**
 * Created by Tom.
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
