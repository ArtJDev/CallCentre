import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TelephoneStation implements Runnable {
    private final ConcurrentLinkedQueue<Integer> base;

    public TelephoneStation(ConcurrentLinkedQueue<Integer> base) {
        this.base = base;
    }

    @Override
    public void run() {
        int limit = 5;
        int callLimit = 5;
        int delay = 50;
        int interval = 1000;
        int count = 0;
        Random random = new Random();

        try {
            for (int i = 0; i < limit; i++) {
                for (int j = 0; j < callLimit; j++) {
                    base.add(random.nextInt(interval));
                    count++;
                    Thread.sleep(delay);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поступило " + count + " звонков");
    }
}
