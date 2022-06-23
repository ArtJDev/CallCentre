import java.util.concurrent.ConcurrentLinkedDeque;

public class Operator implements Runnable {
    private final int ANSWER_TIME = 2000;
    private final ConcurrentLinkedDeque<Integer> base;

    public Operator(ConcurrentLinkedDeque<Integer> base) {
        this.base = base;
    }

    @Override
    public void run() {
        int count = 0;
        while (!base.isEmpty()) {
            base.pollFirst();
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
