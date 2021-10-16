package cn.supfox.stream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class TestStreamThreadPool {

    public static void main(String[] args) throws InterruptedException {
        Stream<Logger> s = Stream.of(
                 new Logger("Error "),
                 new Logger("Warning "),
                 new Logger("Debug "));
        ExecutorService es = Executors.newCachedThreadPool();
        s.forEach(l -> {
            System.out.println("1111"+ l);
            es.execute(l);
        });
        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);
    }
}
