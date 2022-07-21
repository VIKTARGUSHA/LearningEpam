package MainTask.Tonnel.Lock;

public class TrainTonnel2SecondDirection extends Thread {
    TonnelTwo tonnel;
    int directionNumber;
    public TrainTonnel2SecondDirection(TonnelTwo tonnel, int tonnelNumber){
        this.tonnel = tonnel;
        this.directionNumber = tonnelNumber;
    }

    public void run() {
        tonnel.trainGoesThroughTonnelTwo(directionNumber);
    }
}

