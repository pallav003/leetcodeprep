import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Singleton {
    private static volatile Singleton instance;
    private int value;
    public int getValue() { return value; }

    private Singleton() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        value = (int) (Math.random() * 1000);
        System.out.println("Singleton created with value: " + value);
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Runnable task = () -> {
            Singleton s = Singleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " sees value: " + s.getValue());
        };
        for (int i = 0; i < 10; i++) {
            executor.submit(task);
        }
        executor.shutdown();
    }
}


