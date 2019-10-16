package priv.just1984.deep.in.java.basic.demo;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-08 9:47
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        try {
            CompletableFuture.runAsync(() -> {
                throw new RuntimeException("JUST1984");
            }).thenRunAsync(() -> {
                throw new RuntimeException("JUST1985");
            }).whenComplete((res, ex) -> {
                System.out.println("inner catch : " + ex.getMessage());
            });
        } catch (Exception e) {
            System.out.println("outer catch : " + e.getMessage());
        }

        Thread.sleep(5000);
    }

}
