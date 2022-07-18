package MainTask.Tonnel;

import java.util.concurrent.*;

public class Tonnel {
    CountDownLatch countDownLatch = new CountDownLatch(200);
    ExecutorService executorServiceTonnel1 = Executors.newSingleThreadExecutor();
    ExecutorService executorServiceTonnel2 = Executors.newSingleThreadExecutor();
    volatile int tonnel1FirstDirectionTrainNumber = 0;
    volatile int tonnel1SecondDirectionTrainNumber = 0;
    volatile int tonnel2FirstDirectionTrainNumber = 0;
    volatile int tonnel2SecondDirectionTrainNumber = 0;

    Tonnel() throws BrokenBarrierException, InterruptedException, ExecutionException {
        ExecutorService executorService1 = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 50; i++) {
            //   Thread.sleep(100);
            // System.out.println("---------------------------------------");
            executorService1.submit(new TrainTonnel1FirstDirection());
            //      executorService1.submit(new TrainTonnel1SecondDirection());
            executorService1.submit(new TrainTonnel2FirstDirection());
            //  executorService1.submit(new TrainTonnel2SecondDirection());
        }

        countDownLatch.await();
        Thread.sleep(150);
        System.out.println("all the trains went through the tonnel");
        executorService1.shutdown();
        executorServiceTonnel1.shutdown();
        executorServiceTonnel2.shutdown();
    }

    class TrainTonnel1FirstDirection implements Callable<String> {
        @Override
        public synchronized String call() throws ExecutionException, InterruptedException {
            executorServiceTonnel1.submit(new TrainTonnel2Direction());

            executorServiceTonnel1.submit(new TrainTonnel1Direction());
        }

    class TrainTonnel1Direction implements Callable<String> {
        @Override
        public synchronized String call() throws ExecutionException, InterruptedException {
            System.out.println("Train " + tonnel1SecondDirectionTrainNumber + executorServiceTonnel1
                    .submit(new TrainTonnel1SecondDirectionLounch()).get());
         //   try {
                System.out.println("Train " + tonnel1FirstDirectionTrainNumber + executorServiceTonnel1
                        .submit(new TrainTonnel1FirstDirectionLounch()).get());
          /*  } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                try {
                    System.out.println("Train " + tonnel1SecondDirectionTrainNumber + executorServiceTonnel1
                            .submit(new TrainTonnel1SecondDirectionLounch()).get() + " (this train was redirected)");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                }
            }
*/

    //        try {
         /*5, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                try {
                    System.out.println("Train " + tonnel1FirstDirectionTrainNumber + executorServiceTonnel1
                            .submit(new TrainTonnel1FirstDirectionLounch()).get() + " (this train was redirected)");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                }
            */
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

    //    class TrainTonnel1SecondDirection implements Callable<String> {
//        @Override
//        public String call() throws Exception {
//            for (int i = 0; i < 100; i++) {
//
//                System.out.println("Train " + i + executorServiceTonnel1.submit(new TrainTonnel1SecondDirectionLounch()).get());
//
//            }
//            return Thread.currentThread().getName() + "Train went through Tonnel 1 second direction";
//        }
//    }
    class TrainTonnel1SecondDirectionLounch implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Train " + tonnel1SecondDirectionTrainNumber++ + " start moving to 1 tonnel second direction");
            countDownLatch.countDown();
        //    Thread.sleep(50);
            return "Train went through Tonnel 1 second direction";
        }
    }



    class TrainTonnel2Direction implements Callable<String> {
        @Override
        public synchronized String call() throws ExecutionException, InterruptedException {
            System.out.println("Train " + tonnel2SecondDirectionTrainNumber + executorServiceTonnel2
                    .submit(new TrainTonnel2SecondDirectionLounch()).get());
    //        try {
                System.out.println("Train " + tonnel2FirstDirectionTrainNumber + executorServiceTonnel2
                        .submit(new TrainTonnel2FirstDirectionLounch()).get());/*5, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                try {
                    System.out.println("Train " + tonnel2SecondDirectionTrainNumber + executorServiceTonnel2
                            .submit(new TrainTonnel2SecondDirectionLounch()).get() + " (this train was redirected)");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                }
            }
            */
      //      try {
             /*5, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                try {
                    System.out.println("Train " + tonnel1SecondDirectionTrainNumber + executorServiceTonnel2
                            .submit(new TrainTonnel2FirstDirectionLounch()).get() + " (this train was redirected)");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                }
            }
*/
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

    //    class TrainTonnel2SecondDirection implements Callable<String> {
//        @Override
//        public String call() throws Exception {
//            for (int i = 0; i < 100; i++) {
//
//                System.out.println("Train " + i + executorServiceTonnel2.submit(new TrainTonnel2SecondDirectionLounch()).get());
//
//            }
//            return Thread.currentThread().getName() + "Train went through Tonnel 2 second direction";
//        }
//    }
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
