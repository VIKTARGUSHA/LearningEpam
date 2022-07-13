package MainTask.Tonnel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TonnelExecuter {
    SimpleDateFormat sdf = null;
    private final int COUNT = 5;

    public TonnelExecuter() {
        sdf = new SimpleDateFormat("HH:mm:ss.S");
        CountDownLatch cdw1 = new CountDownLatch(COUNT);
        CountDownLatch cdw2 = new CountDownLatch(COUNT);
        CountDownLatch cdw3 = new CountDownLatch(COUNT);
        CountDownLatch cdw4 = new CountDownLatch(COUNT);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new MyThread( cdw1,  "Thread.1"));
        executorService.execute(new MyThread(cdw2, "Thread.2"));
        executorService.execute(new MyThread( cdw3, "Thread.3"));
        executorService.execute(new MyThread( cdw4, "Thread.4"));

        try{
            cdw1.await();
            cdw2.await();
            cdw3.await();
            cdw4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("Завершение потоков");
    }
        void printMessage(final String templ) {
            String text = sdf.format(new Date()) + templ;
            System.out.println(text);

       class MyThread implements Runnable {
            String n;
            CountDownLatch cdl;
            MyThread(CountDownLatch cdl, String n) {
                this.n = n;
                this.cdl = cdl;
                new Thread(this);
            }

            @Override
            public void run() {
                try {
                    for (int i = 0; i < COUNT; i++) {
                        printMessage(n + " " + i);
                        cdl.countDown();
                        Thread.sleep((int) (Math.random() * 1500));
                    }
                    printMessage(n + " completed");
                } catch (InterruptedException e) {
                }
            }}}

    public static void main(String[] args) {
        new TonnelExecuter();
    }
    }

