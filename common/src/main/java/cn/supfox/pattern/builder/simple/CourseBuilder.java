package cn.supfox.pattern.builder.simple;

/**
 * Created by Tom.
 */
public class CourseBuilder{

    private Course course = new Course();

    public void addName(String name) {
        course.setName(name);
    }
    
    public void addPPT(String ppt) {
        course.setPpt(ppt);
    }
    
    public void addVideo(String video) {
        course.setVideo(video);
    }
    
    public void addNote(String note) {
        course.setNote(note);
    }
    
    public void addHomework(String homework) {
        course.setHomework(homework);
    }

    public CourseBuilder note(String note) {
        course.setNote(note);
        return this;
    }
    
    public Course build() {
        return course;
    }
}
