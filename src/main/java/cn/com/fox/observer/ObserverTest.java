package cn.com.fox.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author dmb
 * @since 2019/8/26
 */
public class ObserverTest {

    public static void main(String[] args) {

        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("数据改变了");
            }
        };

        MyObservable myObservable = new MyObservable();

        myObservable.addObserver(observer);
        myObservable.setData(6);
    }
}
