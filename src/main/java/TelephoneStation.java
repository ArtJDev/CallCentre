import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TelephoneStation implements Runnable {
    private final int LIMIT = 5;
    private final int CALL_LIMIT = 5;
    private final int DELAY = 500;
    private final int INTERVAL = 1000;
    private final ConcurrentLinkedDeque<Integer> base;

    public TelephoneStation(ConcurrentLinkedDeque<Integer> base) {
        this.base = base;
    }

    @Override
    public void run() {
        Random random = new Random();
        int count = 0;
        try {
            for (int i = 0; i < LIMIT; i++) {
                for (int j = 0; j < CALL_LIMIT; j++) {
                    base.addLast(random.nextInt(INTERVAL));
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
