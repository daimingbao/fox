package cn.supfox.pattern.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();


        PojoEvent guavaEvent = new PojoEvent();
        VoEvent voEvent = new VoEvent();
        eventBus.register(guavaEvent);
        eventBus.register(voEvent);

        //先执行这个方法，再事件回调<br>
        eventBus.post(new Pojo("Tom"));
    }
}
