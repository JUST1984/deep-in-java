package priv.just1984.deep.in.java.demo.business.consumer;

import lombok.extern.slf4j.Slf4j;
import priv.just1984.deep.in.java.demo.business.domain.Exportable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-28 17:06
 */
@Slf4j
public abstract class ExportableConsumer<T extends Exportable> implements Runnable {

    private BlockingQueue<T> queue;

    private CountDownLatch exportCountDown;

    public ExportableConsumer(BlockingQueue<T> queue, CountDownLatch exportCountDown) {
        this.queue = queue;
        this.exportCountDown = exportCountDown;
    }

    @Override
    public void run() {
        try {
            while (true) {
                T exportable = queue.take();
                process(exportable);
                exportCountDown.countDown();
            }
        } catch (Exception e) {
            log.error("consumer task error", e);
        }
    }

    /**
     * 处理数据
     * @param exportable
     */
    protected abstract void process(T exportable);

}
