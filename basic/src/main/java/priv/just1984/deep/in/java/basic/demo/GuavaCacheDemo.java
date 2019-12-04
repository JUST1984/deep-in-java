package priv.just1984.deep.in.java.basic.demo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-12-04 20:32
 */
public class GuavaCacheDemo {

    private static LoadingCache<Integer, String> cache;

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private static Random random = new Random();

    public static void main(String[] args) {
        cache = CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .maximumSize(1 << 10).build(new CacheLoader<Integer, String>() {
            @Override
            public String load(Integer key) throws Exception {
                Thread.sleep(random.nextInt(2000));
                return UUID.randomUUID().toString();
            }
        });

        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                try {
                    String value = cache.get(random.nextInt(1000));
                    if (StringUtils.isBlank(value)) {
                        System.out.println("error");
                    }
                    System.out.println(value);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
