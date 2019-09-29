package priv.just1984.deep.in.java.demo.concurrency;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-29 9:39
 */
public class InterruptDemo {

    public static void main(String[] args) {
        Thread pThread = new Thread(() -> {
            Thread cThread = new Thread(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("child thread interrupted");
                }
            });
            cThread.start();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("parent thread interrupted");
                cThread.interrupt();
            }
        });
        pThread.start();
        pThread.interrupt();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
