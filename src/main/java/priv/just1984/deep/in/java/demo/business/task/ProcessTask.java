package priv.just1984.deep.in.java.demo.business.task;

import lombok.extern.slf4j.Slf4j;
import priv.just1984.deep.in.java.demo.business.domain.Exportable;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-28 14:04
 */
@Slf4j
public abstract class ProcessTask<T extends Exportable> implements Runnable {

    private List<T> exportableList;

    private CountDownLatch exportCountDown;

    private CountDownLatch processCountDown;

    public ProcessTask(List<T> exportableList, CountDownLatch exportCountDown, CountDownLatch processCountDown) {
        this.exportableList = exportableList;
        this.exportCountDown = exportCountDown;
        this.processCountDown = processCountDown;
    }

    @Override
    public void run() {
        try {
            exportableList.add(process());
        } catch (Exception e) {
            exportCountDown.countDown();
            log.error("single process error", e);
        } finally {
            processCountDown.countDown();
            release();
        }
    }

    protected void release() {}

    /**
     * 处理单位数据
     * @return
     * @throws Exception
     */
    protected abstract T process() throws Exception;

}
