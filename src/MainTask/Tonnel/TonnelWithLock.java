package MainTask.Tonnel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TonnelWithLock {

    public static void main(String[] args) {
        Tonnel1 tonnel1 = new Tonnel1();
        Tonnel2 tonnel2 = new Tonnel2();
        synchronized (tonnel1) {

            new Thread (tonnel1::allowTrainLeft).start();
            new Thread(tonnel1::allowTrainRight).start();
            new Thread(tonnel2::allowTrainLeft).start();
            new Thread(tonnel2::allowTrainRight).start();
        }
        }
    }

     class Tonnel1 {

        public void allowTrainLeft() {
            System.out.println("Train goes to Tonnel 1 left direction");
        }

        public void allowTrainRight() {
            System.out.println("Train goes to Tonnel 1 right direction");
        }
    }
         class Tonnel2{

            public void allowTrainLeft(){
                System.out.println("Train goes to Tonnel 2 left direction");
            }
            public void allowTrainRight(){
                System.out.println("Train goes to Tonnel 2 right direction");
            }
    }
}
