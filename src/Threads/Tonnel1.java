package Threads;

public class Tonnel1 {


public synchronized void add(){
    int someFigure = 0;
    for (int i = 0; i < 500; i++) {
        System.out.println(Thread.currentThread().getName() + " " + "TrainLeft " + someFigure);
        someFigure++;
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
}
