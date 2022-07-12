package MainTask.Parking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
    int quantityFreePlaces = 15;
    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();
    int carNumber = 0;

    public void carArriveFreePlaceOne() throws InterruptedException {

        if (lock.tryLock(10, TimeUnit.SECONDS)) {
            try {
                Thread.currentThread().setName(carNumber + "");
                System.out.println(Thread.currentThread().getName() + " occupied first free place");
                TimeUnit.SECONDS.timedJoin(Thread.currentThread(), (int) (Math.random() * 9));
                System.out.println("car " + carNumber++ + " left");
            } finally {
                Thread.currentThread().interrupt();
                lock.unlock();
            }

        } else System.out.println(Thread.currentThread().getName() + " left to anather parking");
    }

    public void carArriveFreePlaceTwo() throws InterruptedException {

        if (lock.tryLock(10, TimeUnit.SECONDS)) {
            try {
                Thread.currentThread().setName(carNumber++ + "");
                System.out.println(Thread.currentThread().getName() + " occupied second free place");
                TimeUnit.SECONDS.timedJoin(Thread.currentThread(), (int) (Math.random() * 15));
                System.out.println("car " + carNumber + " left");
            } finally {

                Thread.currentThread().interrupt();
                lock.unlock();
            }
        }
    }
}





