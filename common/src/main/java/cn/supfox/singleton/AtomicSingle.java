package cn.supfox.singleton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * @author dmb
 * @since 2019/11/10
 */
public class AtomicSingle {

    private static AtomicReference<AtomicSingle> atomicSingle = new AtomicReference<>();

    private AtomicSingle(){}


    public static AtomicSingle getSingleton() {

        if (atomicSingle.get() == null) {
            boolean b = atomicSingle.compareAndSet(null, new AtomicSingle());
        }
        return atomicSingle.get();
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        Set<AtomicSingle> set = new HashSet();
        List<AtomicSingle> list = new ArrayList<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(101);
        for (int i=0 ; i< 100; i++) {
            final int b = i;
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                AtomicSingle singleton = AtomicSingle.getSingleton();
                list.add(singleton);
                set.add(singleton);
                System.out.println(b+"---->"+singleton);
            }).start();
        }

        cyclicBarrier.await();
        System.out.println(set.size());
        System.out.println(list.size());

        LockSupport.park();
    }

}
