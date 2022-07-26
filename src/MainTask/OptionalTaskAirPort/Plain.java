package MainTask.OptionalTaskAirPort;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Plain extends Thread {
    Semaphore semaphore;

    public Plain(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    RunwayStrip runwayStrip1 = new RunwayStrip(1, semaphore);
    RunwayStrip runwayStrip2 = new RunwayStrip(2, semaphore);
    RunwayStrip runwayStrip3 = new RunwayStrip(3, semaphore);
    RunwayStrip runwayStrip4 = new RunwayStrip(4, semaphore);
    RunwayStrip runwayStrip5 = new RunwayStrip(5, semaphore);
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    Lock lock3 = new ReentrantLock();
    Lock lock4 = new ReentrantLock();
    Lock lock5 = new ReentrantLock();
    Lock lock6 = new ReentrantLock();
    public void run() {

        System.out.println("The plain " + Thread.currentThread().getName() + " started enter to runway strip");

        if (lock1.tryLock()) {
            try {
                try {
                    runwayStrip1.takeRunWayStrip(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock1.unlock();
            }
        } else if (lock2.tryLock()) {
            try {
                try {
                    runwayStrip2.takeRunWayStrip(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock2.unlock();
            }
        } else if (lock3.tryLock()) {
            try {
                try {
                    runwayStrip3.takeRunWayStrip(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock3.unlock();
            }
        } else if (lock4.tryLock()) {
            try {
                try {
                    runwayStrip4.takeRunWayStrip(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock4.unlock();
            }
        } else if (lock5.tryLock()) {
            try {
                try {
                    runwayStrip5.takeRunWayStrip(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock5.unlock();
            }
        }
    }
}