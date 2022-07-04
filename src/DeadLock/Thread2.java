package DeadLock;

public class Thread2 extends Thread {

    public Thread2(InviteAction invite1, InviteAction invite2){
        invite2.invite(invite1);
    }
}
