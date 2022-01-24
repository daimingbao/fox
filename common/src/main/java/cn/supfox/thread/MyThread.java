package cn.supfox.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyThread extends Thread {

    @Override
    public void run() {
        //业务逻辑
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        //业务逻辑
    }
}

class MyCallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        //业务逻辑
        return null;
    }
}
