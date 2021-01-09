package cn.supfox.pattern.delegate.simple;

/**
 * Created by Tom.
 */
public class Boss {
    //可以成员变量也可以 参数传过来，看有没有必要<br>
    public void command(String task,Leader leader){

        leader.doing(task);
    }
}
