package DeadLock;

import java.util.concurrent.TimeUnit;

public class SecondThread extends Thread{
    DeadLock deadLock1;
    DeadLock deadLock2;
   SecondThread(DeadLock d, DeadLock e){
       deadLock1 = d;
       deadLock2 = e;
   }
    public void run(){
        System.out.println(Thread.currentThread().getName() + " " + "SecondThread");
        try {
            deadLock1.write(deadLock2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            deadLock2.print(deadLock1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
