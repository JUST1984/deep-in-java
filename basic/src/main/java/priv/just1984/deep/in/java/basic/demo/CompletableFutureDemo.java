package priv.just1984.deep.in.java.basic.demo;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-08 9:47
 */
public class CompletableFutureDemo {

    private static Random random = new Random();

    public static void main(String[] args) throws Exception {
        /*CompletableFuture<Void> future = CompletableFuture.allOf(CompletableFuture.runAsync(() -> {
            sleep(2000);
            System.out.println(1);
        }), CompletableFuture.runAsync(() -> {
            sleep(1000);
            System.out.println(2);
        }));
        future.get();
        System.out.println(3);*/

        /*CompletableFuture[] futureArray = new CompletableFuture[] {CompletableFuture.runAsync(() -> {
            sleep(2000);
            System.out.println(1);
        }), CompletableFuture.runAsync(() -> {
            sleep(1000);
            System.out.println(2);
        })};

        Method andTreeMethod = CompletableFuture.class.getDeclaredMethod("andTree", CompletableFuture[].class, int.class, int.class);
        andTreeMethod.setAccessible(true);
        CompletableFuture future = (CompletableFuture) andTreeMethod.invoke(null, futureArray, 0, futureArray.length - 1);
        future.get();
        System.out.println(3);*/

        /*CompletableFuture<LinkedList<Object>> future = CompletableFuture.supplyAsync(LinkedList::new).thenCombine(CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            System.out.println(1);
            return 1;
        }), (list, res) -> {
            list.add(res);
            return list;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            System.out.println(2);
            return 2;
        }), (list, res) -> {
            list.add(res);
            return list;
        }).thenApply(list -> list);
        LinkedList<Object> res = future.get();
        System.out.println(res);*/


        CompletableFuture<LinkedList<Object>> future = CompletableFuture.supplyAsync(LinkedList::new);
        for (int i = 0; i < 100; i++) {
            int j = i;
            future = future.thenCombine(CompletableFuture.supplyAsync(() -> {
                System.out.printf("线程：【%s】，编号：【%s】\n", Thread.currentThread().getName(), j);
                sleep(1000);
                return j;
            }), (list, res) -> {
                list.add(res);
                return list;
            });
        }
        LinkedList<Object> res = future.get();
        System.out.println("finish");
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
