package DeadLock;

import java.util.Date;

public class MainLock {
    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        FirstThread firstThread = new FirstThread(deadLock1, deadLock2);
        SecondThread secondThread = new SecondThread(deadLock1, deadLock2);
        firstThread.start();
        secondThread.start();

    }
}