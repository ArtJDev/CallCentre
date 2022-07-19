import java.util.concurrent.ConcurrentLinkedQueue;

public class Operator implements Runnable {
    private static final int ANSWER_TIME = 2000;
    private final ConcurrentLinkedQueue<Integer> base;

    public Operator(ConcurrentLinkedQueue<Integer> base) {
        this.base = base;
    }

    @Override
    public void run() {
        int count = 0;
        while (!base.isEmpty()) {
            base.poll();
            count++;
            try {
                Thread.sleep(ANSWER_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " обработал " + count + " звонков");
    }
}