package DeadLock;

public class Thread2 extends Thread {

      InviteAction invite1;
      InviteAction invite2;

    public Thread2(InviteAction invite1, InviteAction invite2){
        this.invite1 = invite1;
        this.invite2 = invite2;
    }

    public void run(){
        invite2.invite(invite1);
    }
}
