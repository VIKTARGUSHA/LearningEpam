package MainTask.Port1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Port1 {
    private static final int maxPortCapacity = 100;
    private static final int maxShipCapacity = 10;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockQueue = new LinkedBlockingQueue<>(Port1.maxPortCapacity);
        int delay = 0;
        for (int k = 0; k < 10; k++) {
            int finalK1 = k;
            new Thread(() -> {
                // Thread.currentThread().join();
                //TimeUnit.MILLISECONDS.timedJoin(Thread.currentThread(), 100);
                //Thread.sleep(100);
                Thread.currentThread().setName("Terminal 1, ship " + finalK1);
                int shipCapacity =(int) (Math.random()*10);
                int shipCapacityCollect = (int) (Math.random()*10);
                System.out.println(Thread.currentThread().getName() + " ship has "
                        + shipCapacity + " whereas port capacity: " + blockQueue.size() + " and ship collects " + shipCapacityCollect );
                for (int i = 0; i < shipCapacity; i++) {
                    blockQueue.offer(1);
                }
                for (int j = 0; j < shipCapacityCollect; j ++) {
                    blockQueue.poll();
                }
            }).start();

            if(delay < 1) {
                Thread.sleep(100);
                delay++;
            }

            new Thread(() -> {
                // Thread.currentThread().join();
                //  TimeUnit.MILLISECONDS.timedJoin(Thread.currentThread(), 100);
                Thread.currentThread().setName("Terminal 2, ship " + finalK1);
                int shipCapacity = (int) (Math.random()*maxShipCapacity);
                int shipCapacityCollect = (int) (Math.random()*maxShipCapacity);
                System.out.println(Thread.currentThread().getName() + " ship has "
                        + shipCapacity + " whereas port capacity: " + blockQueue.size() + " and ship collects " + shipCapacityCollect );

                for (int i = 0; i < shipCapacity; i++) {
                    blockQueue.offer(1);
                }
                for (int j = 0; j < shipCapacityCollect; j++) {
                    blockQueue.poll();
                }
            }).start();
           // Thread.sleep(50);
        }
    }
}
