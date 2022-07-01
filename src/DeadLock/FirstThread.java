package DeadLock;

public class FirstThread extends Thread{
   DeadLock deadLock1;
   DeadLock deadLock2;
    FirstThread(DeadLock d, DeadLock e){
        deadLock1 = d;
        deadLock2 = e;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " " + "FirstThread");
        try {
            deadLock1.print(deadLock2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            deadLock1.write(deadLock2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
