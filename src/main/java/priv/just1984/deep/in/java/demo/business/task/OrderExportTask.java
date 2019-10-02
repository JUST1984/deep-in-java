package priv.just1984.deep.in.java.demo.business.task;

import priv.just1984.deep.in.java.demo.business.domain.ExportableOrder;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-30 18:12
 */
public class OrderExportTask extends AbstractExportTask<ExportableOrder> {

    public OrderExportTask(Executor executor) {
        super(executor);
    }

    @Override
    protected int getExportCount() {
        return 0;
    }

    @Override
    protected File generateFile() {
        return null;
    }

    @Override
    protected AbstractProducerTask<ExportableOrder> generateProducer(BlockingQueue<ExportableOrder> queue, CountDownLatch exportCountDown, Executor executor) {
        return new OrderProducerTask(queue, exportCountDown, executor);
    }

    @Override
    protected AbstractConsumerTask<ExportableOrder> generateConsumer(BlockingQueue<ExportableOrder> queue, CountDownLatch exportCountDown, File file) {
        return new ConsumerToExcelTask<ExportableOrder>(queue, exportCountDown, file) {};
    }


}
