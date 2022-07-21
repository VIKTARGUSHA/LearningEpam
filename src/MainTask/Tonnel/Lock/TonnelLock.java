package MainTask.Tonnel.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TonnelLock {

    TonnelFirst1 tonnelFirst1 = new TonnelFirst1();
    TonnelSecond2 tonnelSecond2 = new TonnelSecond2();
    TonnelFirst1 tonnelFirst11 = new TonnelFirst1(tonnelSecond2);
   TonnelSecond2 tonnelSecond22 = new TonnelSecond2(tonnelFirst1);
    public static void main(String[] args) {
        for (int j = 0; j < 25; j++) {

            new Thread(tonnelFirst1::goLeft);
            new Thread(() -> {
                try {
                    tonnelFirst1.goRight();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    tonnelSecond1.goLeft();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            try {
                new Thread(tonnelSecond1::goRight);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

//    class TonnelFirst {
//        TonnelSecond tonnelSecond;
//
//        public TonnelFirst(TonnelSecond tonnelSecond) {
//            this.tonnelSecond = tonnelSecond;
//        }
//        TonnelFirst(){
//
//        }
//
//        public void goLeft() throws InterruptedException {
//            if (lock.tryLock(15, TimeUnit.SECONDS)) {
//                System.out.println(Thread.currentThread() + " Train is going through the first tonnel");
//            } else {
//                System.out.println(Thread.currentThread() + " was redirected");
//                tonnelSecond.goLeft();
//            }
//        }
//
//        public void goRight() throws InterruptedException {
//            if (lock.tryLock(15, TimeUnit.SECONDS)) {
//                System.out.println(Thread.currentThread() + " Train is going through the first tonnel");
//            } else {
//                System.out.println(Thread.currentThread() + " was redirected");
//                tonnelSecond.goRight();
//            }
//            System.out.println();
//        }
//    }
//
//
//    class TonnelSecond {
//        TonnelFirst tonnelFirst;
//
//        public TonnelSecond(TonnelFirst tonnelFirst) {
//            this.tonnelFirst = tonnelFirst;
//        }
//        TonnelSecond(){
//
//        }
//
//        public void goLeft() throws InterruptedException {
//            if (lock.tryLock(15, TimeUnit.SECONDS)) {
//                System.out.println(Thread.currentThread() + " Train is going through the first tonnel");
//            } else {
//                System.out.println(Thread.currentThread() + " was redirected");
//                tonnelFirst.goLeft();
//            }
//        }
//
//        public void goRight() throws InterruptedException {
//            if (lock.tryLock(15, TimeUnit.SECONDS)) {
//                System.out.println(Thread.currentThread() + " Train is going through the first tonnel");
//            } else {
//                System.out.println(Thread.currentThread() + " was redirected");
//                tonnelFirst.goRight();
//            }
//        }
//    }
}
