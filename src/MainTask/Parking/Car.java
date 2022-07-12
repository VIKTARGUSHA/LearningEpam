package MainTask.Parking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
    int carNumber;
    public Car(){

    }
    public Car(int carNumber){
        this.carNumber = carNumber;
    }
    Lock lock = new ReentrantLock();
    public void getLastPlace() throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " is looking for a place");
            if(lock.tryLock(5, TimeUnit.SECONDS)) {
                try {

                    System.out.println(Thread.currentThread().getName() + " parked in 1 place ");
                    TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 10);
                    System.out.println(Thread.currentThread().getName() + " left 1 place");
                } finally {
                    lock.unlock();
                }
            } else if(lock.tryLock(5, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " parked in 2 place ");
                    TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 10);
                    System.out.println(Thread.currentThread().getName() + " left 2 place");
                }finally {
                    lock.unlock();
                }
            }else {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + " went away");
            }
            }
    }

