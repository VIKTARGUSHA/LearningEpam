package MainTask.Tonnel.Lock;

public class TrainTonnel1FirstDirection extends Thread {
TonnelOne tonnel;
int directionNumber;
public TrainTonnel1FirstDirection(TonnelOne tonnel, int tonnelNumber){
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