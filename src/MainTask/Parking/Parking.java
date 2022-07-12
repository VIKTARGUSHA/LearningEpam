package MainTask.Parking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {
    public static void main(String[] args) {
        Car car = new Car();
        for (int i = 0; i < 25; i++) {
            int finalI = i;
            new Thread(() -> {

                try {
                    TimeUnit.SECONDS.timedJoin(Thread.currentThread(), (int)(Math.random()*360));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.currentThread().setName("Car " + finalI);
                try {
                    car.getLastPlace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}


