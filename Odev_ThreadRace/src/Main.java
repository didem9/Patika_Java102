
public class Main {
    public static void main(String[] args) {
        Numeration num = new Numeration();

        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);
        Thread t3 = new Thread(num);
        Thread t4 = new Thread(num);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tek Sayılar: " + Numeration.odds.size());
        System.out.println("Çift Sayılar : " + Numeration.evens.size());

    }
}

