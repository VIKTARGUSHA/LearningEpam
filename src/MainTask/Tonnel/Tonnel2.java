package MainTask.Tonnel;

public class Tonnel2 {

    public void allowTrainLeft() {
        synchronized (this) {
            System.out.println(Thread.currentThread() + " train goes to Tonnel 2 left direction");
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
            System.out.println(Thread.currentThread() + " train went through Tonnel 2 left direction");
        }
    }

    public void allowTrainRight() {
        synchronized (this) {
            System.out.println(Thread.currentThread() + " train goes to Tonnel 2 right direction");
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
            System.out.println(Thread.currentThread() + " train went through Tonnel 2 right direction");
   //     }
    }
}
