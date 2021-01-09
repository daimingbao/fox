package cn.supfox.pattern.bridge.course;

/**
 * Created by Tom.
 * 可以先参考下抽象工程，这里通过AbstractCourse把ICourse/INote/IVideo这些维度衔接起来了<br>
 *  肯定不是通过JavaCourse implements ICourse,INote来实现而是通过AbstractCourse来组合<br>
 */
public class AbstractCourse implements ICourse {
    private INote note;
    private IVideo video;

    public void setNote(INote note) {
        this.note = note;
    }

    public void setVideo(IVideo video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "AbstractCourse{" +
                "note=" + note +
                ", video=" + video +
                '}';
    }
}
