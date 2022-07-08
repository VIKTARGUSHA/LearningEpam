package MainTask.Parking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {
    Lock lock = new ReentrantLock();


    private static int quantityFreePlaces = 15;
    public void takeOfThePlace(){
        System.out.println("Some car is looking for a place");

    }

}
