package MainTask.Tonnel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclingBarier {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        for (int i = 0; i < 12; i++) {
Thread.sleep(2500);
            int finalI = i;
            new Thread(() -> {

                System.out.println("Hay " + finalI);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello " + finalI);
            }).start();
        }
       // cyclicBarrier.await();
        System.out.println("The end");

    }
}