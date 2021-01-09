package cn.supfox.pattern.factory.abstractFactory;

/**
 * Created by Tom.
 */
public class PythonCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new PythonNote();
    }


    public IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }

//    @Override
    protected IQuestion createQuestion() {
        super.init();
        return new PythonQuestion();
    }
}
