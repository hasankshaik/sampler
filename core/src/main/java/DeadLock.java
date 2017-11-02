import java.util.function.Consumer;
import java.util.function.Function;

public class DeadLock {
    String resourceOne="Java";
    String resourceTwo="Scala";
    Runnable t1 = () -> {
        while (true) {
            synchronized (resourceOne) {
                synchronized (resourceTwo) {
                    System.out.println("PrintMe");
                }
            }
        }
    };
    Runnable t2 = () -> {
        while (true) {
            synchronized (resourceTwo) {
                synchronized (resourceOne) {
                    System.out.println("PrintMe");
                }
            }
        }
    };

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Consumer<Runnable> runnableConsumer=(Runnable r1)-> new Thread(r1).start();
        runnableConsumer.accept(deadLock.t1);
        runnableConsumer.accept(deadLock.t2);
    }

}
