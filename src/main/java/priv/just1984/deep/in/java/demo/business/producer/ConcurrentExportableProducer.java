package priv.just1984.deep.in.java.demo.business.producer;

import priv.just1984.deep.in.java.demo.business.domain.Exportable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-28 12:35
 */
public abstract class ConcurrentExportableProducer<T extends Exportable> extends ExportableProducer<T> {

    private static final int DEFAULT_PROCESS_COUNT = 200;

    private Executor executor;

    public ConcurrentExportableProducer(BlockingQueue<T> queue, CountDownLatch exportCountDown, Executor executor) {
        super(queue, exportCountDown);
        this.executor = executor;
    }

    @Override
    protected List<T> process() {
        List<T> exportableList = Collections.synchronizedList(new ArrayList<>(getProcessCount()));
        CountDownLatch processCountDown = new CountDownLatch(getProcessCount());
        return null;
    }

    protected int getProcessCount() {
        return DEFAULT_PROCESS_COUNT;
    }

}
