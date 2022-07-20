package MainTask.Tonnel;

import java.util.concurrent.*;

public class Tonnel {
    CountDownLatch countDownLatch = new CountDownLatch(200);
    ExecutorService executorServiceTonnel1 = Executors.newFixedThreadPool(100);
    ExecutorService executorServiceTonnel2 = Executors.newFixedThreadPool(100);
    volatile int tonnel1FirstDirectionTrainNumber = 0;
    volatile int tonnel1SecondDirectionTrainNumber = 0;
    volatile int tonnel2FirstDirectionTrainNumber = 0;
    volatile int tonnel2SecondDirectionTrainNumber = 0;

    Tonnel() throws InterruptedException {
        ExecutorService executorService1 = Executors.newFixedThreadPool(100);
Callable<String> t1 = new TrainTonnel1FirstSecondDirection();
Callable<String> t2 = new TrainTonnel2FirstSecondDirection();
        for (int i = 0; i < 50; i++) {

            executorService1.submit(t1);
            executorService1.submit(t2);

        }

        countDownLatch.await();
        Thread.sleep(150);
        System.out.println("all the trains went through the tonnel");
        executorService1.shutdown();
        executorServiceTonnel1.shutdown();
        executorServiceTonnel2.shutdown();
    }

    class TrainTonnel1FirstSecondDirection implements Callable<String> {
        @Override
        public synchronized String call() throws InterruptedException {
            executorServiceTonnel1.submit(new TrainTonnel1DirectionS());
            executorServiceTonnel1.submit(new TrainTonnel1DirectionF());
         Thread.sleep(1000);
            return "";
        }
    }
    class TrainTonnel1DirectionF implements Callable<String> {
        @Override
        public  String call() throws ExecutionException, InterruptedException {
            System.out.println("Train " + tonnel1SecondDirectionTrainNumber + executorServiceTonnel1
                    .submit(new TrainTonnel1SecondDirectionLounch()).get());

            return " ";
        }
    }
    class TrainTonnel1DirectionS implements Callable<String> {
        @Override
        public  String call() throws ExecutionException, InterruptedException {


            System.out.println("Train " + tonnel1FirstDirectionTrainNumber + executorServiceTonnel1
                    .submit(new TrainTonnel1FirstDirectionLounch()).get());

            return " ";
        }
    }

    class TrainTonnel1FirstDirectionLounch implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Train " + tonnel1FirstDirectionTrainNumber++ + " start moving to 1 tonnel first direction");
         //   Thread.sleep(50);
            countDownLatch.countDown();

            return "Train went through Tonnel 1 first direction";
        }
    }
    class TrainTonnel1SecondDirectionLounch implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Train " + tonnel1SecondDirectionTrainNumber++ + " start moving to 1 tonnel second direction");
            countDownLatch.countDown();

            return "Train went through Tonnel 1 second direction";
        }
    }





    class TrainTonnel2FirstSecondDirection implements Callable<String> {
        @Override
        public synchronized String call() throws ExecutionException, InterruptedException {
            executorServiceTonnel2.submit(new TrainTonnel2DirectionS());
            executorServiceTonnel2.submit(new TrainTonnel2DirectionF());
     TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 1);
            return "";
        }
    }
    class TrainTonnel2DirectionS implements Callable<String> {
        @Override
        public String call() throws ExecutionException, InterruptedException {
            System.out.println("Train " + tonnel2SecondDirectionTrainNumber + executorServiceTonnel2
                    .submit(new TrainTonnel2SecondDirectionLounch()).get());


            return " ";
        }
    }
    class TrainTonnel2DirectionF implements Callable<String> {
        @Override
        public String call() throws ExecutionException, InterruptedException {
            System.out.println("Train " + tonnel2FirstDirectionTrainNumber + executorServiceTonnel2
                    .submit(new TrainTonnel1SecondDirectionLounch()).get());


            return " ";
        }
    }



    class TrainTonnel2FirstDirectionLounch implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Train " + tonnel2FirstDirectionTrainNumber++ + " start moving to 2 tonnel first direction");
            countDownLatch.countDown();
         //   Thread.sleep(50);
            return "Train went through Tonnel 2 first direction";
        }
    }
    class TrainTonnel2SecondDirectionLounch implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Train " + tonnel2SecondDirectionTrainNumber++ + " start moving to 2 tonnel second direction");
            countDownLatch.countDown();
         //   Thread.sleep(50);
            return "Train went through Tonnel 2 second direction";
        }
    }


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, ExecutionException {
        Tonnel tonnel = new Tonnel();
    }
}
