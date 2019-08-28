package cn.com.fox.observer;

import lombok.Data;

import java.util.Observable;

/**
 * @author dmb
 * @since 2019/8/26
 */
@Data
public class MyObservable extends Observable {

    private int data;

    public void setData(int data) {
        this.data = data;
        setChanged();
        this.notifyObservers();
    }

}
