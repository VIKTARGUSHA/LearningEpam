package MainTask.Tonnel.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TonnelTwo {
    Lock lock = new ReentrantLock();
    TonnelOne tonnelOne = new TonnelOne();
    public TonnelTwo(TonnelOne tonnelOne){
        this.tonnelOne = tonnelOne;
    }
    public TonnelTwo(){

    }
    public void trainGoesThroughTonnelTwo(int i) throws InterruptedException {
        if(lock.tryLock(10, TimeUnit.SECONDS)){
            try {
                if (i == 1) {
                    System.out.println(Thread.currentThread().getName() + " train started going through tonnel 2 first direction |-> 2");
                    Thread.sleep(250);
                    System.out.println(Thread.currentThread().getName() + " train finished moving through tonnel 2 first direction ->| 2");
                }
                if (i == 2) {
                    System.out.println(Thread.currentThread().getName() + " train started going through tonnel 2 second direction <-| 2");
                    Thread.sleep(250);
                    System.out.println(Thread.currentThread().getName() + " train finished moving through tonnel 2 second direction |<- 2");
                }
                if (i == 3) {
                    System.out.println(Thread.currentThread().getName() + " train started going through tonnel 2 first direction (This train was redirected))");
                    Thread.sleep(250);
                    System.out.println(Thread.currentThread().getName() + " train finished moving through tonnel 2 first direction (This train was redirected)");
                }
                if (i == 4) {
                    System.out.println(Thread.currentThread().getName() + " train started going through tonnel 2 second direction (This train was redirected))");
                    Thread.sleep(250);
                    System.out.println(Thread.currentThread().getName() + " train finished moving through tonnel 2 second direction (This train was redirected)");
                }
            }finally {
                lock.unlock();
            }
        }else {
            if (i == 1){
                Thread thread = new TrainTonnel1FirstDirection(tonnelOne, 3);
          //      System.out.println(Thread.currentThread().getName() + " train started going through tonnel 2 second direction");
                thread.start();
            }
            if (i == 2){
                Thread thread = new TrainTonnel1SecondDirection(tonnelOne,4);
          //      System.out.println(Thread.currentThread().getName() + " train started going through tonnel 2 first direction");
                thread.start();
            }
            if (i == 3){
                Thread thread = new TrainTonnel2FirstDirection(this, 3);
                thread.start();
            }
            if(i == 4){
                Thread thread = new TrainTonnel2SecondDirection(this, 4);
                thread.start();
            }
        }
    }
}
