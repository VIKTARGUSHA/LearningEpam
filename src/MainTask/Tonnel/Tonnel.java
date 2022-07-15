package MainTask.Tonnel;

import java.util.concurrent.*;

public class Tonnel {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newScheduledThreadPool(2);
        Future<String> f = executorService.submit(new ExecuterDemo());

    }
public class TrainTonnel1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Train goes through 1 tonnel";

    }
}
}
