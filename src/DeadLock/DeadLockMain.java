package DeadLock;

public class DeadLockMain {
    public static void main(String[] args) {
        InviteAction invite1 = new InviteAction("first");
        InviteAction invite2 = new InviteAction("second");
        Thread thread1 = new Thread1(invite1, invite2);
        Thread thread2 = new Thread2(invite1, invite2);
        thread1.start();
        thread1.start();
    }
}
