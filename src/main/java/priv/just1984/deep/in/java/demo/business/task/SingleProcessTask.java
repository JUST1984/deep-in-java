package priv.just1984.deep.in.java.demo.business.task;

import priv.just1984.deep.in.java.demo.business.domain.Exportable;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-28 14:04
 */
public abstract class SingleProcessTask<T extends Exportable> implements Runnable {

    private CountDownLatch exportCountDown;

    private CountDownLatch processCountDown;

    private List<T> exportableList;

    @Override
    public void run() {

    }

}
