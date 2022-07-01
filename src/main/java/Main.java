import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final ConcurrentLinkedQueue<Integer> base = new ConcurrentLinkedQueue<>();

        Thread telephoneStation = new Thread(new TelephoneStation(base), "АТС");
        Thread operator1 = new Thread(new Operator(base), "Оператор 1");
        Thread operator2 = new Thread(new Operator(base), "Оператор 2");
        Thread operator3 = new Thread(new Operator(base), "Оператор 3");

        telephoneStation.start();
        telephoneStation.join();
        operator1.start();
        operator2.start();
        operator3.start();
    }
}