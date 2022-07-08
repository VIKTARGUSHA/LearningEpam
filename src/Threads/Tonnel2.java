package Threads;

public class Tonnel2 {
    int amount = 0;

    public void goes(String s) throws InterruptedException {
        for (int i = 0; i < 250; i++) {
            amount++;
            Thread.sleep(10);
            System.out.println(s + " train is going " + i  + " " + amount);
        }
    }
}