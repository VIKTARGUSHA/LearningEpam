package DeadLock;

public class Thread1 extends Thread {
InviteAction invite1;
InviteAction invite2;

    public Thread1(InviteAction invite1, InviteAction invite2){
        this.invite1 = invite1;
        this.invite2 = invite2;
    }

    public void run(){

        invite1.invite(invite2);
    }
}
