package BlockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockQueue = new LinkedBlockingQueue<>(5);
        new Thread(() -> {
            for (int i = 0; i < 8; i ++){
                try {
                    blockQueue.put("Java " + i);
                    System.out.println("Element index " + i + " add ");
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++){
                try {
                    System.out.println("Element index " + blockQueue.take() + " took");
                  //  TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
//TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 5);
        Thread.sleep(5000);
        System.out.println(blockQueue);
    }
}
