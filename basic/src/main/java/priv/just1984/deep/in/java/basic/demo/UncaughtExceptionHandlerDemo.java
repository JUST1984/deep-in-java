package priv.just1984.deep.in.java.basic.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-28 19:17
 */
public class UncaughtExceptionHandlerDemo {

    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    public static void main(String[] args) {
        executor.setThreadFactory(new MyThreadFactory(executor.getThreadFactory()));
        executor.execute(() -> {
            throw new RuntimeException("JUST1984");
        });
    }

    private static class MyThreadFactory implements ThreadFactory {

        private ThreadFactory delegate;

        public MyThreadFactory(ThreadFactory delegate) {
            this.delegate = delegate;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread res = delegate.newThread(r);
            res.setUncaughtExceptionHandler((t, e) -> {
                System.out.println(e.getMessage());
            });
            return res;
        }

    }

}
