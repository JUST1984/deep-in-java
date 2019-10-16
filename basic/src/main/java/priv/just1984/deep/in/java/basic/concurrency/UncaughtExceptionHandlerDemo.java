package priv.just1984.deep.in.java.basic.concurrency;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-12 14:55
 */
public class UncaughtExceptionHandlerDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            throw new RuntimeException("JUST1984");
        });
        t.start();

        Thread.sleep(5000);
    }

}
