package MainTask.Tonnel.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TonnelOne {
    Lock lock = new ReentrantLock();

    public void trainGoesThroughTonnelOne(int i) throws InterruptedException {
        if (lock.tryLock(15, TimeUnit.SECONDS)) {
            if (i == 1) {
                System.out.println(Thread.currentThread().getName() + " train started going through tonnel 1 first direction");
            } else {
                System.out.println(Thread.currentThread().getName() + " train started going through tonnel 1 second direction");
            }
        }
    }
}