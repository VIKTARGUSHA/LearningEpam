package Threads;

public class MainTonnel {
    public static void main(String[] args) throws InterruptedException {
        Tonnel2 tonnel2 = new Tonnel2();
        TrainLeft trainLeft = new TrainLeft(tonnel2);
        TrainRight trainRightt = new TrainRight(tonnel2);
        Thread trainRight = new Thread(trainRightt);
        trainRight.start();
        trainLeft.start();
    }
}