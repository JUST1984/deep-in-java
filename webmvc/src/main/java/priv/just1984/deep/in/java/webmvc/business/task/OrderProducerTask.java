package priv.just1984.deep.in.java.webmvc.business.task;

import priv.just1984.deep.in.java.webmvc.business.domain.ExportableOrder;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-30 18:12
 */
public class OrderProducerTask extends AbstractConcurrentProducerTask<ExportableOrder> {

    public OrderProducerTask(BlockingQueue<ExportableOrder> queue, CountDownLatch exportCountDown, Executor executor) {
        super(queue, exportCountDown, executor);
    }

    @Override
    protected List<AbstractProcessTask> getProcessTaskList(List<ExportableOrder> exportableList, CountDownLatch processCountDown, CountDownLatch exportCountDown) {
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
