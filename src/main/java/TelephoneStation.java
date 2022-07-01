import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TelephoneStation implements Runnable {
    private static final int LIMIT = 5;
    private static final int CALL_LIMIT = 5;
    private static final int DELAY = 50;
    private static final int INTERVAL = 1000;
    private final ConcurrentLinkedQueue<Integer> base;

    public TelephoneStation(ConcurrentLinkedQueue<Integer> base) {
        this.base = base;
    }

    @Override
    public void run() {
        Random random = new Random();
        int count = 0;
        try {
            for (int i = 0; i < LIMIT; i++) {
                for (int j = 0; j < CALL_LIMIT; j++) {
                    base.add(random.nextInt(INTERVAL));
                    count++;
                    Thread.sleep(DELAY);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поступило " + count + " звонков");
    }
}