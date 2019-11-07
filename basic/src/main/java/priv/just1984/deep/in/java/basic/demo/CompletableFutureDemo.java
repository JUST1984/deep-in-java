package priv.just1984.deep.in.java.basic.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-08 9:47
 */
public class CompletableFutureDemo {

    private static Random random = new Random();

    private static ExecutorService executorService = Executors.newCachedThreadPool();

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


        /*CompletableFuture<LinkedList<Object>> future = CompletableFuture.supplyAsync(LinkedList::new, executorService);
        for (int i = 0; i < 100; i++) {
            int j = i;
            future = future.thenCombine(CompletableFuture.supplyAsync(() -> {
                sleep((long) (Math.random() * 1000));
                System.out.printf("线程：【%s】，编号：【%s】\n", Thread.currentThread().getName(), j);
                return j;
            }, executorService), (list, res) -> {
                list.add(res);
                return list;
            });
        }
        LinkedList<Object> res = future.get();
        System.out.println(res);
        System.out.println("finish");*/

        /*List<Integer> res = new ArrayList<>();
        List<CompletableFuture<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int j = i;
            futureList.add(CompletableFuture.supplyAsync(() -> {
                sleep((long) (Math.random() * 1000));
                System.out.println(j);
                res.add(j);
                return j;
            }, executorService));
        }

        CompletableFuture<Void> future = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));
        future.get();
        System.out.println(res);*/

        // 效率低
        CompletableFuture<ArrayList<Integer>> future = CompletableFuture.supplyAsync(ArrayList<Integer>::new);
        for (int i = 0; i < 1000; i++) {
            final int j = i;
            future = future.thenCombineAsync(CompletableFuture.supplyAsync(() -> j), (list, data) -> {
                list.add(data);
                return list;
            });
        }
        ArrayList<Integer> res = future.get();
        System.out.println(res);

        // 效率高
        List<CompletableFuture<Integer>> futures = Stream.iterate(0, i -> i + 1).limit(1000).map(i ->
                CompletableFuture.supplyAsync(() -> i)).collect(Collectors.toList());
        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        CompletableFuture<List<Integer>> resFuture = allFuture.thenApply(v ->
                futures.stream().map(CompletableFuture::join).collect(Collectors.toList()));
        System.out.println(resFuture.get());



        sleep(100000);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
