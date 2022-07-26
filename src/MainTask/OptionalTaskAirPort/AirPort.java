package MainTask.OptionalTaskAirPort;

import java.util.concurrent.Semaphore;

public class AirPort {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);
        Plain plain = new Plain(semaphore);
for (int i = 0; i < 10; i++){
//    semaphore.acquire();
    Thread thread = new Thread(plain);
    thread.setName("Plane " + i);
    thread.start();
}
    }
}