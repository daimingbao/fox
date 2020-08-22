package cn.supfox.singleton;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class Singleton implements Serializable {

    private static Singleton singleton = null;

    private static List<Integer> intList = new ArrayList<>();

    private Singleton()  {
        if (Objects.nonNull(singleton)) {
            throw new RuntimeException("");
        }
        System.out.println("initied singleton");
    }

    public static Singleton instance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    /**
     *  <p>Another typical usage would be to divide a problem into N parts,
     *  * describe each part with a Runnable that executes that portion and
     *  * counts down on the latch, and queue all the Runnables to an
     *  * Executor.  When all sub-parts are complete, the coordinating thread
     *  * will be able to pass through await. (When threads must repeatedly
     *  * count down in this way, instead use a {@link CyclicBarrier}.)
     *  *
     *  *  <pre> {@code
     *  * class Driver2 { // ...
     *  *   void main() throws InterruptedException {
     *  *     CountDownLatch doneSignal = new CountDownLatch(N);
     *  *     Executor e = ...
     *  *
     *  *     for (int i = 0; i < N; ++i) // create and start threads
     *  *       e.execute(new WorkerRunnable(doneSignal, i));
     *  *
     *  *     doneSignal.await();           // wait for all to finish
     *  *   }
     *  * }
     *  *
     *  * class WorkerRunnable implements Runnable {
     *  *   private final CountDownLatch doneSignal;
     *  *   private final int i;
     *  *   WorkerRunnable(CountDownLatch doneSignal, int i) {
     *  *     this.doneSignal = doneSignal;
     *  *     this.i = i;
     *  *   }
     *  *   public void run() {
     *  *     try {
     *  *       doWork(i);
     *  *       doneSignal.countDown();
     *  *     } catch (InterruptedException ex) {} // return;
     *  *   }
     *  *
     *  *   void doWork() { ... }
     *  * }}</pre>
     * @param args
     */

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                5,
                10 , TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().setPriority(1).setThreadFactory(Executors.defaultThreadFactory()).build(),
                new ThreadPoolExecutor.DiscardPolicy());

        CountDownLatch countDownLatch = new CountDownLatch(15);
        for (int i = 0; i< 15 ; i++) {
            int finalI = i;
            executor.submit(() -> {
                countDownLatch.countDown();
                System.out.println("调用"+finalI);
                intList.add(finalI);
                for (int i1 : intList){
                    System.out.println(intList.remove(i1));
                }
                System.out.println(MyInstance.singleton);
            });

        }
        countDownLatch.await();
        executor.shutdown();

        System.out.println("===" +intList.size());
        System.out.println("==="+intList.size());

        File tempFile = File.createTempFile("/tmp", ".bin");
        //序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempFile));
        objectOutputStream.writeObject(MyInstance.singleton);

        System.out.println("\n");
        //反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(tempFile));

        Singleton o = (Singleton) objectInputStream.readObject();
        System.out.println(o);


        System.out.println(MyInstance.singleton);
    }

    public Object readResolve() {
        return MyInstance.singleton;
    }

    private static class MyInstance {
        public static Singleton singleton = new Singleton();
    }
}
