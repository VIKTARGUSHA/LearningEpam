package MainTask.Auction;

import java.util.concurrent.BrokenBarrierException;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class Participant implements Runnable, Callable<String> {
    NamePlate namePlate;
    static volatile int currentGeneralBet = 0;
    int thisBet;
    public static String nameLastParticipant;
    public String name;
    Boolean b = true;
    int counterGaps = 0;
    static Boolean interapter = true;
    public static boolean lotTime;

    public Participant(String name, CyclicBarrier c, NamePlate namePlate, Boolean b) {
        this.name = name;
        nameLastParticipant = name;
        this.namePlate = namePlate;
    }

    @Override
    public synchronized void run() {
        Participant.interapter = true;
        lotTime = false;
        if (b) {
            for (int j = 0; j < 3; j++) {
                try {
                    nameLastParticipant = namePlate.nameName(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Participant.makeBet();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                thisBet = currentGeneralBet;
                if (j == 2) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (thisBet == Participant.currentGeneralBet && Participant.nameLastParticipant.equals(name)) {
                System.out.println(name + " have to pay for the lot " + thisBet);

                try {
                    Thread.sleep((int)(Math.random()*3000));
                  //  Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(Participant.interapter) {
                    System.out.println(nameLastParticipant + " paid for lot " + Auktion.lotNumber + " " + currentGeneralBet);
                    Auktion.indicatorPaying = false;
                    lotTime = true;
                }else {
                    b = false;
                    lotTime = true;
                }

            }

        } else {
            System.out.println("Participant " + name + " is missing this lot");
            counterGaps++;
            if (counterGaps == 2) {
                b = true;
                counterGaps = 0;
            }
        }
    }

    public static synchronized void makeBet() throws BrokenBarrierException, InterruptedException {
        int add = (int) (Math.random() * 100);
        currentGeneralBet += add;

        System.out.println("Participant " + nameLastParticipant + " add " + add + " and make bet: " + currentGeneralBet);
        Thread.sleep(100);

    }

    @Override
    public String call() throws Exception {
        this.run();
        return null;
    }
}
