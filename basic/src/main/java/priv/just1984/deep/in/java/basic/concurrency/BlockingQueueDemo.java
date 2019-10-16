package priv.just1984.deep.in.java.basic.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-29 8:58
 */
public class BlockingQueueDemo {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        executor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    queue.put(i);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
    }

}
