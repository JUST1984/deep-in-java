package priv.just1984.deep.in.java.demo.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-29 11:22
 */
public class RunnableInterruptDemo {

    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    public static void main(String[] args) {
        executor.setThreadFactory(new ThreadFactoryDecorator(executor.getThreadFactory()));
        executor.execute(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("thread interrupted");
            }
            System.out.println("finish");
        });
        ThreadFactoryDecorator.getThread(0).interrupt();
    }
    
    private static class ThreadFactoryDecorator implements ThreadFactory {
        private ThreadFactory threadFactory;
        private static List<Thread> threadList = new ArrayList<>();
        public ThreadFactoryDecorator(ThreadFactory threadFactory) {
            this.threadFactory = threadFactory;
        }
        @Override
        public Thread newThread(Runnable r) {
            Thread t = threadFactory.newThread(r);
            threadList.add(t);
            return t;
        }
        public static Thread getThread(int index) {
            return threadList.get(index);
        }
    }

}
