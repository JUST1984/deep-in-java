package priv.just1984.deep.in.java.demo.business.task;

import priv.just1984.deep.in.java.demo.business.consumer.ExportableConsumer;
import priv.just1984.deep.in.java.demo.business.domain.Exportable;
import priv.just1984.deep.in.java.demo.business.producer.ExportableProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-27 17:24
 */
public class ExportTask<T extends Exportable> implements Runnable {

    private int exportCount;

    private AtomicInteger exportRate;

    private CountDownLatch exportCountDown;

    private BlockingQueue<T> queue;

    private ExportableProducer<T> producer;

    private ExportableConsumer<T> consumer;

    private Executor executor;

    public ExportTask() {

    }

    @Override
    public void run() {
        executor.execute(producer);
        executor.execute(consumer);
        try {
            exportCountDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
