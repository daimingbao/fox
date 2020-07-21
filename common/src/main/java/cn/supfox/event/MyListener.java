package cn.supfox.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EventListener;

public class MyListener implements EventListener {

    private Logger log = LoggerFactory.getLogger("MY-LISTENER");

    public void listen(MyEventObject myEventObject) {
        log.info("MyListener listened"+ myEventObject);

    }
}
