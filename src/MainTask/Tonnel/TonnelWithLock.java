package MainTask.Tonnel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TonnelWithLock {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(25);
        Tonnel1 tonnel1 = new Tonnel1();
        Tonnel2 tonnel2 = new Tonnel2();
        for (int i = 0; i < 25; i++) {

                new Thread(tonnel1::allowTrainLeft).start();
                new Thread(tonnel1::allowTrainRight).start();
                new Thread(tonnel2::allowTrainLeft).start();
                new Thread(tonnel2::allowTrainRight).start();
                countDownLatch.countDown();
            }
        countDownLatch.await();
        Thread.sleep(100);
        System.out.println("All the trains went through both tonnels");
        }
    }


