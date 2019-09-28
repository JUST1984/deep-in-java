package priv.just1984.deep.in.java.demo.business.producer;

import priv.just1984.deep.in.java.demo.business.domain.Exportable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-27 17:56
 */
public abstract class ExportableProducer<T extends Exportable> implements Runnable {

    private BlockingQueue<T> queue;

    protected CountDownLatch exportCountDown;

    public ExportableProducer(BlockingQueue<T> queue, CountDownLatch exportCountDown) {
        this.queue = queue;
        this.exportCountDown = exportCountDown;
    }

    @Override
    public void run() {
        do {
            List<T> exportableList = process();
            if (needSort()) {
                exportableList.sort(getComparator());
            }
            Iterator<T> iterator = exportableList.iterator();
            while (iterator.hasNext()) {
                queue.offer(iterator.next());
                iterator.remove();
            }
        } while (hasMore());
    }

    protected  boolean hasMore() {
        return false;
    };

    /**
     * 是否需要排序
     * @return
     */
    protected abstract boolean needSort();

    /**
     * 获取比较器
     * @return
     */
    protected abstract Comparator<T> getComparator();

    /**
     * 处理批量数据
     * @return
     */
    protected abstract List<T> process();

}
