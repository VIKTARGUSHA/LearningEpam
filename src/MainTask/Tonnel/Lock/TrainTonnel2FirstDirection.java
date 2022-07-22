package MainTask.Tonnel.Lock;

public class TrainTonnel2FirstDirection extends Thread {
    TonnelTwo tonnel;
    int directionNumber;
    public TrainTonnel2FirstDirection(TonnelTwo tonnel, int tonnelNumber){
        this.tonnel = tonnel;
        this.directionNumber = tonnelNumber;
    }

    public void run() {
        try {
            tonnel.trainGoesThroughTonnelTwo(directionNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

