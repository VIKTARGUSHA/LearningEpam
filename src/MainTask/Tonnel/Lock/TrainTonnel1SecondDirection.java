package MainTask.Tonnel.Lock;

public class TrainTonnel1SecondDirection extends Thread {
    TonnelOne tonnel;
    int directionNumber;
    public TrainTonnel1SecondDirection(TonnelOne tonnel, int tonnelNumber){
        this.tonnel = tonnel;
        this.directionNumber = tonnelNumber;
    }

    public void run() {
        try {
            tonnel.trainGoesThroughTonnelOne(directionNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

