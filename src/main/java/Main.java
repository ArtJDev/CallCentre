import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final ConcurrentLinkedDeque<Integer> base = new ConcurrentLinkedDeque<>();

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