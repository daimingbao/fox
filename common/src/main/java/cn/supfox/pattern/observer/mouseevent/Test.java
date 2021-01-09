package cn.supfox.pattern.observer.mouseevent;


import cn.supfox.pattern.observer.mouseevent.handler.Mouse;
import cn.supfox.pattern.observer.mouseevent.handler.MouseEventLisenter;
import cn.supfox.pattern.observer.mouseevent.handler.MouseEventType;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        MouseEventLisenter lisenter = new MouseEventLisenter();

        Mouse mouse = new Mouse();
        mouse.addLisenter(MouseEventType.ON_CLICK,lisenter);
        //mouse.addLisenter(MouseEventType.ON_MOVE,lisenter);

        mouse.click();
        mouse.move();
        //EventContext被观察者/lisenter是观察者<br>
    }
}
