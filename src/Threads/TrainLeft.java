package Threads;

import java.util.concurrent.TimeUnit;

public class TrainLeft extends Thread{
    public void run(){
        for (int i = 0; i < 1000; i ++)
        System.out.println("TrainLeft " + i);

    }
}
