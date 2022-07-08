package SynchronizedMethod;

public class MainMethod {
    public synchronized static void print() throws InterruptedException {
        for (int i = 0; i < 1000; i ++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            Thread.sleep(1);
        }
    }
    public static void main(String[] args) {

        new Thread(() ->{
            try {
                MainMethod.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(() -> {
            try {
                MainMethod.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}