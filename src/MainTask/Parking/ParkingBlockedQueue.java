package MainTask.Parking;

import java.util.concurrent.*;

public class ParkingBlockedQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue <Car> blockingQueue = new ArrayBlockingQueue<>(15, true);
        for(int i = 0; i < 100; i++) {
            int finalI = i;
Thread.sleep((int)(Math.random()*1500));
            new Thread(() -> {
                Thread.currentThread().setName("Car " + finalI );
                Car car = new Car((int)(Math.random()*89999+ 10000));
                System.out.println(car.carNumber + " is looking for a place");
                try {
                    if (blockingQueue.offer(car, 10, TimeUnit.SECONDS)) {
                        System.out.println("car " + car.carNumber + " took place" + " " + blockingQueue.size());

                    try {
                        TimeUnit.SECONDS.timedJoin(Thread.currentThread(), (int) (Math.random() * 50));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    blockingQueue.remove(car);
                        System.out.println("car " + car.carNumber + " left from it place");
                }else {
                        System.out.println("car " + car.carNumber + " is lack of place");
                    }
            } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }).start();
        }
    }
}
