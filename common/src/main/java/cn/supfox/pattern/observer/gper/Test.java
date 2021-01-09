package cn.supfox.pattern.observer.gper;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        GPer gper = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher jerry = new Teacher("Jerry");

        //这个是使用了Observable的api/Observable.addObserver(tom)<br>
        gper.addObserver(tom);
        gper.addObserver(jerry);

        //用户行为
        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式适用于哪些场景？");

        gper.publishQuestion(question);
    }
}
