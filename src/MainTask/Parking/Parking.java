package MainTask.Parking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {

    public static void main(String[] args) {
        Car car = new Car();
        for (int i = 0; i < 100; i++) {

            new Thread(() -> {
//for (int i = 0; i < 100; i++){
                try {
                    TimeUnit.SECONDS.timedJoin(Thread.currentThread(), (int)(Math.random()*160));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    car.carArriveFreePlaceOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();

            new Thread(() -> {
                try {
                    car.carArriveFreePlaceTwo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }}