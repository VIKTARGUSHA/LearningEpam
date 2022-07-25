package MainTask.Auction;

import java.util.concurrent.*;

public class Auktion {

public static boolean indicatorPaying = true;

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(15);
        NamePlate namePlate = new NamePlate();

        Participant jonh = new Participant("Jonh", cyclicBarrier, namePlate, true);
        Participant mike = new Participant("Mike", cyclicBarrier, namePlate, true);
        Participant nick = new Participant("Nick", cyclicBarrier, namePlate, true);
        Participant jack = new Participant("Jack", cyclicBarrier, namePlate, true);
        Participant rosa = new Participant("Rosa", cyclicBarrier, namePlate, true);
        ExecutorService participantLot = Executors.newFixedThreadPool(10);

        int numberOfLots = 5;
        for (int i = 0; i < numberOfLots; i++) {
            Auktion.indicatorPaying = true;
            System.out.println("-----------------------------------------------------------");
            Future<String> future1 = participantLot.submit((Callable<String>) jonh);
            Future<String> future2 = participantLot.submit((Callable<String>) rosa);
            Future<String> future3 = participantLot.submit((Callable<String>) nick);
            Future<String> future4 = participantLot.submit((Callable<String>) jack);
            Future<String> future5 = participantLot.submit((Callable<String>) mike);

            Thread.sleep(3000);

            Participant.interapter = false;

            if(Auktion.indicatorPaying) {
                System.out.println("Participant " + Participant.nameLastParticipant + " make max bet and won this lot: "
                        + i + " for: " + Participant.currentGeneralBet);
            }
            Participant.currentGeneralBet = 0;

        }
        participantLot.shutdown();
    }
}
