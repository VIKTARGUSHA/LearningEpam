package MainTask.Auction;

public class NamePlate {
    String name;
    public synchronized String nameName(Participant participant) throws InterruptedException {
        name = participant.name;
        Thread.sleep(100);
        return name;
    }
}
