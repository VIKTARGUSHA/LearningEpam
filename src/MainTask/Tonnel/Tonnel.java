package MainTask.Tonnel;

import java.util.concurrent.*;

public class Tonnel {

    Tonnel() throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(100);


        ExecutorService executorService1 = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 25; i++) {
            executorService1.submit(new TrainTonnel1FirstDirection());
            executorService1.submit(new TrainTonnel1SecondDirection());
        }

        ExecutorService executorService2 = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 25; i++) {
            executorService1.submit(new TrainTonnel2FirstDirection());
            executorService1.submit(new TrainTonnel2SecondDirection());
        }
cyclicBarrier.await();
        executorService1.shutdown();
        executorService2.shutdown();
    }

    class TrainTonnel1FirstDirection implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Train goes through Tonnel 1 first direction";

        }
    }
        class TrainTonnel1SecondDirection implements Callable<String> {
            @Override
            public String call() throws Exception {
                return "Train goes through Tonnel 1 second direction";
            }
        }
    class TrainTonnel2FirstDirection implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Train goes through Tonnel 2 first direction";
        }
    }
    class TrainTonnel2SecondDirection implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Train goes through Tonnel 2 second direction";
        }
    }
    }
