package cn.supfox.stream;

public class Logger implements Runnable{
    String msg;
    public Logger(String msg) {
        this.msg = msg;
    }
    public void run() {
        System.out.print(msg);
    }

    @Override
    public String toString() {
        return "Logger{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
