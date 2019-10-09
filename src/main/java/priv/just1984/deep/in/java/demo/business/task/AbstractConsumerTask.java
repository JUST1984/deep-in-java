package priv.just1984.deep.in.java.demo.business.task;

import lombok.extern.slf4j.Slf4j;
import priv.just1984.deep.in.java.demo.business.domain.Exportable;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-28 17:06
 */
@Slf4j
public abstract class AbstractConsumerTask<T extends Exportable> implements Runnable {

    private BlockingQueue<T> queue;

    private CountDownLatch exportCountDown;

    private File file;

    public AbstractConsumerTask(BlockingQueue<T> queue, CountDownLatch exportCountDown, File file) {
        this.queue = queue;
        this.exportCountDown = exportCountDown;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            while (exportCountDown.getCount() > 0) {
                process(queue.take(), file);
                exportCountDown.countDown();
            }
        } catch (Exception e) {
            log.error("consumer task error", e);
        }
    }

    /**
     * 处理数据
     * @param exportable
     * @param file
     */
    protected abstract void process(T exportable, File file);

}
