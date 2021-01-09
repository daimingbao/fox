package cn.supfox.pattern.factory.abstractFactory;

/**
 * Created by Tom.
 */
public class JavaCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    public IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }

//    @Override
//    protected IQuestion createQuestion() {
//        super.init();
//        return new JavaQuestion();
//    }
}
