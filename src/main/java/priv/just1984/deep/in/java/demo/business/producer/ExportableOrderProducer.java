package priv.just1984.deep.in.java.demo.business.producer;

import priv.just1984.deep.in.java.demo.business.domain.ExportableOrder;
import priv.just1984.deep.in.java.demo.business.task.ProcessTask;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class ExportableOrderProducer extends ConcurrentExportableProducer<ExportableOrder> {

    public ExportableOrderProducer(BlockingQueue<ExportableOrder> queue, CountDownLatch exportCountDown, Executor executor) {
        super(queue, exportCountDown, executor);
    }

    @Override
    protected List<ProcessTask> getProcessTaskList(List<ExportableOrder> exportableList, CountDownLatch processCountDown, CountDownLatch exportCountDown) {
        return null;
    }

    @Override
    protected boolean needSort() {
        return true;
    }

    @Override
    protected Comparator<ExportableOrder> getComparator() {
        return Comparator.comparingLong(order -> order.getCreateDate().getTime());
    }

}
