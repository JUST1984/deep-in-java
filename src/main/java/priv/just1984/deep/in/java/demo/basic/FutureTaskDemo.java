package priv.just1984.deep.in.java.demo.basic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-08 13:58
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws InterruptedException {
        FutureTask future = new FutureTask(() -> {
            throw new ExecutionException(new RuntimeException("JUST1984"));
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(5000);
    }

}
