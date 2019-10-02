package priv.just1984.deep.in.java.demo.business.task;

import priv.just1984.deep.in.java.demo.business.domain.Exportable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-28 12:35
 */
public abstract class AbstractConcurrentProducerTask<T extends Exportable> extends AbstractProducerTask<T> {

    private static final int DEFAULT_PROCESS_COUNT = 200;

    private Executor executor;

    public AbstractConcurrentProducerTask(BlockingQueue<T> queue, CountDownLatch exportCountDown, Executor executor) {
        super(queue, exportCountDown);
        this.executor = executor;
    }

    @Override
    protected List<T> process() throws InterruptedException {
        List<T> exportableList = Collections.synchronizedList(new ArrayList<>(getProcessCount()));
        CountDownLatch processCountDown = new CountDownLatch(getProcessCount());
        List<AbstractProcessTask> processTaskList = getProcessTaskList(exportableList, processCountDown, exportCountDown);
        Iterator<AbstractProcessTask> iterator = processTaskList.iterator();
        while (iterator.hasNext()) {
            executor.execute(iterator.next());
            iterator.remove();
        }
        processCountDown.await();
        return exportableList;
    }

    protected int getProcessCount() {
        return DEFAULT_PROCESS_COUNT;
    }

    /**
     * 获取子任务列表
     * @param exportableList
     * @param processCountDown
     * @param exportCountDown
     * @return
     */
    protected abstract List<AbstractProcessTask> getProcessTaskList(List<T> exportableList, CountDownLatch processCountDown,
                                                                    CountDownLatch exportCountDown);

}
