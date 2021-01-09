package cn.supfox.pattern.observer.general;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        // 被观察者  主题
        ISubject<String> observable = new ConcreteSubject<String>();
        // 观察者
        IObserver<String> observer = new ConcreteObserver<String>();
        // 注册，主题会通知谁
        observable.attach(observer);
        // 通知
        observable.notify("hello");
    }

}
