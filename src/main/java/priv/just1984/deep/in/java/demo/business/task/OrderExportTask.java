package priv.just1984.deep.in.java.demo.business.task;

import priv.just1984.deep.in.java.demo.business.consumer.ExportableConsumer;
import priv.just1984.deep.in.java.demo.business.consumer.ExportableOrderConsumer;
import priv.just1984.deep.in.java.demo.business.domain.ExportableOrder;
import priv.just1984.deep.in.java.demo.business.producer.ExportableOrderProducer;
import priv.just1984.deep.in.java.demo.business.producer.ExportableProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-30 18:12
 */
public class OrderExportTask extends ExportTask<ExportableOrder> {

    public OrderExportTask(Executor executor) {
        super(executor);
    }

    @Override
    protected int getExportCount() {
        return 0;
    }

    @Override
    protected ExportableProducer<ExportableOrder> generateProducer(BlockingQueue<ExportableOrder> queue, CountDownLatch exportCountDown, Executor executor) {
        return new ExportableOrderProducer(queue, exportCountDown, executor);
    }

    @Override
    protected ExportableConsumer<ExportableOrder> generateConsumer(BlockingQueue<ExportableOrder> queue, CountDownLatch exportCountDown) {
        return new ExportableOrderConsumer(queue, exportCountDown);
    }

}
