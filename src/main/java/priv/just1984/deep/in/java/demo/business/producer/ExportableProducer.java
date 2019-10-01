package priv.just1984.deep.in.java.demo.business.producer;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public abstract class ExportableProducer<T extends Exportable> implements Runnable {

    private BlockingQueue<T> queue;

    protected CountDownLatch exportCountDown;

    public ExportableProducer(BlockingQueue<T> queue, CountDownLatch exportCountDown) {
        this.queue = queue;
        this.exportCountDown = exportCountDown;
    }

    @Override
    public void run() {
        try {
            do {
                List<T> exportableList = process();
                if (needSort()) {
                    exportableList.sort(getComparator());
                }
                Iterator<T> iterator = exportableList.iterator();
                while (iterator.hasNext()) {
                    queue.put(iterator.next());
                    iterator.remove();
                }
            } while (hasMore());
        } catch (Exception e) {
            log.error("producer task error", e);
        } finally {
            release();
        }
    }

    protected boolean hasMore() {
        return false;
    }

    protected void release() {}

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
     * 处理单批数据
     * @return
     * @throws Exception
     */
    protected abstract List<T> process() throws Exception;

}
