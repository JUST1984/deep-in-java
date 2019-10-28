package priv.just1984.deep.in.java.basic.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-08 13:58
 */
public class FutureTaskDemo {

    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    public static void main(String[] args) {
        FutureTask<Void> future1 = new FutureTask<>(() -> {
            throw new RuntimeException("JUST1984");
        });

        executor.execute(future1);

        try {
            future1.get();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }

        sleep(10000);

    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
