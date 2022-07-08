package Threads;

public class TrainRight implements Runnable {
    Tonnel2 tonnel2;
    public TrainRight(Tonnel2 tonnel2){
        this.tonnel2 = tonnel2;
    }
public TrainRight(){

}

    @Override
    public void run() {
        String train = "Right";
        try {
            tonnel2.goes(train);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}