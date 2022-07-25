package MainTask.Auction;

import java.util.concurrent.TimeUnit;

public class ThreadInterapter extends Thread{
   static Boolean bb;
    Participant p;
    public ThreadInterapter(Participant p){
        this.p = p;
    }
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
