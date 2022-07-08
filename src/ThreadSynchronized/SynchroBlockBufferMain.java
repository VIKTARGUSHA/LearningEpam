package ThreadSynchronized;

import java.util.concurrent.TimeUnit;

public class SynchroBlockBufferMain {
    static int counter;

    public static void main(String[] args) {
        StringBuffer info = new StringBuffer();
        new Thread(() -> {
//            synchronized (info) {
                do {
                    info.append('A');
                    System.out.println(info);
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (counter++ < 5);
           // }
        }).start();

    //    new Thread(() -> {
//            synchronized (info) {
                while (counter++ < 6) {
                    info.append('Z');
                    System.out.println(info);
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
       //     }
      //  }).start();
    }
}
