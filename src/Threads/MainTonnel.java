package Threads;

public class MainTonnel {
    public static void main(String[] args) {
        TrainLeft trainLeft = new TrainLeft();
        Thread trainRight = new Thread(new TrainRight());
        trainLeft.start();
        trainRight.start();
    }
}
