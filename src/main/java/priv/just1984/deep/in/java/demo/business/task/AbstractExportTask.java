package priv.just1984.deep.in.java.demo.business.task;

import lombok.extern.slf4j.Slf4j;
import priv.just1984.deep.in.java.demo.business.domain.Exportable;
import priv.just1984.deep.in.java.demo.business.exception.BusException;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @description: 批量导出任务
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-27 17:24
 */
@Slf4j
public abstract class AbstractExportTask<T extends Exportable> implements Supplier<File> {

    private static final int DEFAULT_QUEUE_CAPACITY = 1 << 10;

    private static final int DEFAULT_MAX_EXPORT_SECONDS = 30 * 60;

    private Executor executor;

    private int exportCount;

    private CountDownLatch exportCountDown;

    private BlockingQueue<T> queue;

    private AbstractProducerTask<T> producer;

    private AbstractConsumerTask<T> consumer;

    private File file;

    private Instant start;

    public AbstractExportTask(Executor executor) {
        this.start = Instant.now();
        this.executor = executor;
        this.exportCount = getExportCount();
        this.exportCountDown = new CountDownLatch(exportCount);
        this.queue = new LinkedBlockingQueue<>(DEFAULT_QUEUE_CAPACITY);
        this.file = generateFile();
        this.producer = generateProducer(queue, exportCountDown, executor);
        this.consumer = generateConsumer(queue, exportCountDown, file);
    }

    @Override
    public File get() {
        executor.execute(producer);
        executor.execute(consumer);
        try {
            exportCountDown.await(DEFAULT_MAX_EXPORT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new BusException("export timeout (over 30 minutes)");
        }
        log.info("export finish, cost {} seconds", Duration.between(start, Instant.now()).toMillis() / 1000);
        return file;
    }

    /**
     * 获取导出进度（0~1）
     * @return
     */
    public double getRate() {
        return ((double) exportCount - (double) exportCountDown.getCount()) / (double) exportCount;
    }

    /**
     * 获取批量导出总数
     * @return
     */
    protected abstract int getExportCount();

    /**
     * 生成结果文件
     * @return
     */
    protected abstract File generateFile();

    /**
     * 构建生产者任务
     * @param queue
     * @param exportCountDown
     * @param executor
     * @return
     */
    protected abstract AbstractProducerTask<T> generateProducer(BlockingQueue<T> queue, CountDownLatch exportCountDown,
                                                                Executor executor);

    /**
     * 构建消费者任务
     * @param queue
     * @param exportCountDown
     * @param file
     * @return
     */
    protected abstract AbstractConsumerTask<T> generateConsumer(BlockingQueue<T> queue, CountDownLatch exportCountDown,
                                                                File file);

}
