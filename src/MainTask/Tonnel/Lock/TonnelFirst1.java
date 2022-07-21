package MainTask.Tonnel.Lock;

import MainTask.Tonnel.Lock.TonnelSecond2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TonnelFirst1 {
    Lock lock = new ReentrantLock();
TonnelSecond2 tonnelSecond2;
        public TonnelFirst1(TonnelSecond2 tonnelSecond2) {
            this.tonnelSecond2 = tonnelSecond2;
        }
        TonnelFirst1(){

        }

        public void goLeft() throws InterruptedException {
            if (lock.tryLock(15, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread() + " Train is going through the first tonnel");
            } else {
                System.out.println(Thread.currentThread() + " was redirected");
                tonnelSecond2.goLeft();
            }
        }

        public void goRight() throws InterruptedException {
            if (lock.tryLock(15, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread() + " Train is going through the first tonnel");
            } else {
                System.out.println(Thread.currentThread() + " was redirected");
                tonnelSecond2.goRight();
            }
            System.out.println();
        }
    }

