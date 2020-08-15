package cn.supfox.sington;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.util.concurrent.RejectedExecutionHandler;

import javax.inject.Singleton;
import java.util.Objects;
import java.util.concurrent.*;

public class Singlton {

    private static Singlton singlton = null;

    private Singlton()  {
        if (Objects.nonNull(singlton)) {
            throw new RuntimeException("");
        }
    }

    public static Singlton instance() {
        if (singlton == null) {
            synchronized (Singlton.class) {
                if (singlton == null) {
                    singlton = new Singlton();
                }
            }
        }
        return singlton;
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

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                5,
                10 , TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().setPriority(1).setThreadFactory(Executors.defaultThreadFactory()).build(),
                new ThreadPoolExecutor.DiscardPolicy());

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i< 6 ; i++) {
            executor.submit(() -> {
                countDownLatch.countDown();
                System.out.println(Singlton.instance());
            });

        }
        countDownLatch.await();
        executor.shutdown();
    }
}
