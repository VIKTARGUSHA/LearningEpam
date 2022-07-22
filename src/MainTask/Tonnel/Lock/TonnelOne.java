package MainTask.Tonnel.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TonnelOne {
    Lock lock = new ReentrantLock();
    TonnelTwo tonnelTwo;
public TonnelOne(TonnelTwo tonnelTwo){
    this.tonnelTwo = tonnelTwo;
}
public TonnelOne(){

}
    public void trainGoesThroughTonnelOne(int i) throws InterruptedException {
    if(i == 3){

    }
        if (lock.tryLock(10, TimeUnit.SECONDS)) {
            try {
            if (i == 1) {
                    System.out.println(Thread.currentThread().getName() + " train started going through tonnel 1 first direction |-> 1");
                    Thread.sleep(250);
                System.out.println(Thread.currentThread().getName() + " train finished going through tonnel 1 first direction ->| 1");
                }
                if (i == 2) {
                    System.out.println(Thread.currentThread().getName() + " train started going through tonnel 1 second direction <-| 1");
                    TimeUnit.MILLISECONDS.timedJoin(Thread.currentThread(),250);
                    System.out.println(Thread.currentThread().getName() + " train finished going through tonnel 1 second direction |<- 1");
                }
                if (i == 3) {
                    System.out.println(Thread.currentThread().getName() + " train started going through tonnel 1 first direction (This train was redirected)");
                    Thread.sleep(250);
                    System.out.println(Thread.currentThread().getName() + " train finished going through tonnel 1 first direction (This train was redirected)");
                }
                if (i == 4) {
                    System.out.println(Thread.currentThread().getName() + " train started going through tonnel 1 second direction (This train was redirected)");
                    Thread.sleep(250);
                    System.out.println(Thread.currentThread().getName() + " train finished going through tonnel 1 second direction (This train was redirected)");
                }
            }finally {
                lock.unlock();
            }
            } else {
            if (i == 1) {
                Thread thread = new TrainTonnel2FirstDirection(tonnelTwo,3);
      //          System.out.println(Thread.currentThread().getName() + " train started going through tonnel 1 second direction");
                thread.start();
            }
            if ( i == 2){
                Thread thread = new TrainTonnel2SecondDirection(tonnelTwo, 4);
      //          System.out.println(Thread.currentThread().getName() + " train started going through tonnel 1 first direction");
                thread.start();
            }
            if ( i ==3 ){
                Thread thread = new TrainTonnel1FirstDirection(this, 3);
                thread.start();
            }
            if (i == 4){
                Thread thread = new TrainTonnel1SecondDirection(this, 4);
                thread.start();
            }
            }
        }
    }
