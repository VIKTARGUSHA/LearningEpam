package DeadLock;

public class DeadLock {
    public synchronized void print(DeadLock d) throws InterruptedException {
        System.out.println("print");
        for (int i = 0; i < 10000; i++) {

        }
    }

    public synchronized void write(DeadLock e) throws InterruptedException {
        System.out.println("write");
        for (int i = 0; i < 10000; i++) {
        }
    }
}