package MainTask.Tonnel.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TonnelSecond2 {
    Lock lock = new ReentrantLock();
    TonnelFirst1 tonnelFirst1;
    public TonnelSecond2(TonnelFirst1 tonnelFirst1){
        this.tonnelFirst1 = tonnelFirst1;
    }
    TonnelSecond2(){

    }
    public void goLeft() throws InterruptedException {
        if (lock.tryLock(15, TimeUnit.SECONDS)) {
            System.out.println(Thread.currentThread() + " Train is going through the first tonnel");
        } else {
            System.out.println(Thread.currentThread() + " was redirected");
            tonnelFirst1.goLeft();
        }
    }

    public void goRight() throws InterruptedException {
        if (lock.tryLock(15, TimeUnit.SECONDS)) {
            System.out.println(Thread.currentThread() + " Train is going through the first tonnel");
        } else {
            System.out.println(Thread.currentThread() + " was redirected");
            tonnelFirst1.goRight();
        }
    }
}

