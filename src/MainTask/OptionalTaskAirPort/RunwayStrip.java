package MainTask.OptionalTaskAirPort;

import java.util.concurrent.Semaphore;

public class RunwayStrip {
    int numberRunWayStrip;
    Semaphore semaphore;
    public RunwayStrip(int numberRunWayStrip, Semaphore semaphore){
this.numberRunWayStrip = numberRunWayStrip;
this.semaphore = semaphore;
    }
public synchronized void takeRunWayStrip(String plane) throws InterruptedException {
    System.out.println("Plane " + plane + " took " + numberRunWayStrip + " runway strip");
Waiting waiting = new Waiting(numberRunWayStrip, Thread.currentThread().getName());
 Thread thread1 = new Thread(waiting);
 thread1.start();
 thread1.join();
    System.out.println("The run way strip " + numberRunWayStrip + " is free" );
//semaphore.release();
//Thread.currentThread().stop();
}
}
