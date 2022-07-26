package MainTask.OptionalTaskAirPort;

public class Waiting implements Runnable{
    int numberRunWayStrip;
    String plane;
    public Waiting(int numberRunWayStrip, String plane) {
this.numberRunWayStrip = numberRunWayStrip;
this.plane = plane;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Plane " + plane + " has jast taken off from the runway strip " + numberRunWayStrip);
    }
}
