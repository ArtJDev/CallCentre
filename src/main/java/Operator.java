import java.util.concurrent.ConcurrentLinkedQueue;

public class Operator implements Runnable {
    private final ConcurrentLinkedQueue<Integer> base;

    public Operator(ConcurrentLinkedQueue<Integer> base) {
        this.base = base;
    }

    @Override
    public void run() {
        int answerTime = 1000;
        int count = 0;
        while (!base.isEmpty()) {
            base.poll();
            count++;
            try {
                Thread.sleep(answerTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " обработал " + count + " звонков");
    }
}
