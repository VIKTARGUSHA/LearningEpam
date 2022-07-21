package MainTask.Tonnel.Lock;

public class TonnelLock {

    public static void main(String[] args) {
        TonnelOne tonnelOne = new TonnelOne();
        TonnelTwo tonnelTwo = new TonnelTwo();
        for (int j = 0; j < 25; j++) {
            Thread thread1 = new TrainTonnel1FirstDirection(tonnelOne, 1);
            Thread thread2 = new TrainTonnel1SecondDirection(tonnelOne, 2);
            Thread thread3 = new TrainTonnel2FirstDirection(tonnelTwo, 1);
            Thread thread4 = new TrainTonnel2SecondDirection(tonnelTwo, 2);

        }
    }
}