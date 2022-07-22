package MainTask.Tonnel.Lock;

public class TonnelLock {

    public static void main(String[] args) {
        TonnelOne tonnelOne1 = new TonnelOne();
        TonnelTwo tonnelTwo1 = new TonnelTwo();
        TonnelOne tonnelOne = new TonnelOne(tonnelTwo1);
        TonnelTwo tonnelTwo = new TonnelTwo(tonnelOne1);
        for (int j = 0; j < 25; j++) {
            Thread thread1 = new TrainTonnel1FirstDirection(tonnelOne, 1);
            Thread thread2 = new TrainTonnel1SecondDirection(tonnelOne, 2);
            Thread thread3 = new TrainTonnel2FirstDirection(tonnelTwo, 1);
            Thread thread4 = new TrainTonnel2SecondDirection(tonnelTwo, 2);
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
        }
    }
}