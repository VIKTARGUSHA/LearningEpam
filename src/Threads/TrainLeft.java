package Threads;

import java.util.concurrent.TimeUnit;

public class TrainLeft extends Thread{
    public void run(){
        TimeUnit.MILLISECONDS.timedWait();
        System.out.println();
    }
}
