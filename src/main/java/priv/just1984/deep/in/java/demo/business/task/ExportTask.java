package priv.just1984.deep.in.java.demo.business.task;

import lombok.extern.slf4j.Slf4j;
import priv.just1984.deep.in.java.demo.business.consumer.ExportableConsumer;
import priv.just1984.deep.in.java.demo.business.domain.Exportable;
import priv.just1984.deep.in.java.demo.business.producer.ExportableProducer;
import priv.just1984.deep.in.java.demo.exception.ExportException;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-27 17:24
 */
@Slf4j
public abstract class ExportTask<T extends Exportable> implements Runnable {

    private static final int DEFAULT_QUEUE_CAPACITY = 1000;

    private Executor executor;

    private int exportCount;

    private CountDownLatch exportCountDown;

    private BlockingQueue<T> queue;

    private ExportableProducer<T> producer;

    private ExportableConsumer<T> consumer;

    private Instant start;

    public ExportTask(Executor executor) {
        this.executor = executor;
        this.exportCount = getExportCount();
        this.exportCountDown = new CountDownLatch(exportCount);
        this.queue = new LinkedBlockingQueue<>(getQueueCapacity());
        this.producer = generateProducer(queue, exportCountDown, executor);
        this.consumer = generateConsumer(queue, exportCountDown);
        this.start = Instant.now();
    }

    @Override
    public void run() {
        executor.execute(producer);
        executor.execute(consumer);
        try {
            exportCountDown.await();
        } catch (InterruptedException e) {
            log.error("export task interrupted", e);
            throw new ExportException();
        }
        log.info("export finish, cost {} seconds", Duration.between(start, Instant.now()).toMillis() / 1000);
    }

    public double getRate() {
        return ((double) exportCount - (double) exportCountDown.getCount()) / (double) exportCount;
    }

    protected int getQueueCapacity() {
        return DEFAULT_QUEUE_CAPACITY;
    }

    /**
     * 获取批量导出总数
     * @return
     */
    protected abstract int getExportCount();

    /**
     * 构建生产者任务
     * @param queue
     * @param exportCountDown
     * @param executor
     * @return
     */
    protected abstract ExportableProducer<T> generateProducer(BlockingQueue<T> queue, CountDownLatch exportCountDown,
                                                              Executor executor);

    /**
     * 构建消费者任务
     * @param queue
     * @param exportCountDown
     * @return
     */
    protected abstract ExportableConsumer<T> generateConsumer(BlockingQueue<T> queue, CountDownLatch exportCountDown);

}
