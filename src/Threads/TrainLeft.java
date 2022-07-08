package Threads;

import java.util.concurrent.TimeUnit;

public class TrainLeft extends Thread {
    Tonnel2 tonnel2;

    public TrainLeft(Tonnel2 tonnel2) {
        this.tonnel2 = tonnel2;
    }

    public TrainLeft() {

    }

    public void run() {
        String train = "Left";
        try {
            tonnel2.goes(train);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}