package priv.just1984.deep.in.java.demo.concurrency;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-12 15:41
 */
public class DaemonDemo {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // t.setDaemon(true);
        t.start();
    }

}
