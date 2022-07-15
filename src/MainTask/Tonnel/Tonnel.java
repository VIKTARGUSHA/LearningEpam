package MainTask.Tonnel;

import java.util.concurrent.*;

public class Tonnel {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
    Tonnel() throws BrokenBarrierException, InterruptedException, ExecutionException {



        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 25; i++) {
            Thread.sleep(1000);
            System.out.println(executorService1.submit(new TrainTonnel1FirstDirection()).get());
//            System.out.println(executorService1.submit(new TrainTonnel1SecondDirection(cyclicBarrier)).get());
        }

//        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 25; i++) {
//            System.out.println(executorService1.submit(new TrainTonnel2FirstDirection(cyclicBarrier)).get());
//            System.out.println(executorService1.submit(new TrainTonnel2SecondDirection(cyclicBarrier)).get());
//        }
     //   cyclicBarrier.await();
        System.out.println("all the trains went through the tonnel");
        executorService1.shutdown();
//        executorService2.shutdown();

    }

    class TrainTonnel1FirstDirection implements Callable<String> {
//        CyclicBarrier cyclicBarrier;
//        TrainTonnel1FirstDirection(CyclicBarrier cyclicBarrier){
//            this.cyclicBarrier = cyclicBarrier;
//        }
        @Override
        public String call() throws Exception {

            cyclicBarrier.await();
            return "Train goes through Tonnel 1 first direction";
        }
    }

    class TrainTonnel1SecondDirection implements Callable<String> {
        CyclicBarrier cyclicBarrier;
        TrainTonnel1SecondDirection(CyclicBarrier cyclicBarrier){
           this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public String call() throws Exception {
            Thread.sleep(11);
//            System.out.println("Train goes through Tonnel 1 second direction");
            cyclicBarrier.await();
            return "Train goes through Tonnel 1 second direction";
        }
    }

    class TrainTonnel2FirstDirection implements Callable<String> {
        CyclicBarrier cyclicBarrier;
        TrainTonnel2FirstDirection(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public String call() throws Exception {
            Thread.sleep(11);

                cyclicBarrier.await();

            return "Train goes through Tonnel 2 first direction";
        }
    }

    class TrainTonnel2SecondDirection implements Callable<String> {
        CyclicBarrier cyclicBarrier;
        TrainTonnel2SecondDirection(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public String call() throws Exception {
            cyclicBarrier.await();
            Thread.sleep(11);
            return "Train goes through Tonnel 2 second direction";
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, ExecutionException {
        Tonnel tonnel = new Tonnel();
    }
}
