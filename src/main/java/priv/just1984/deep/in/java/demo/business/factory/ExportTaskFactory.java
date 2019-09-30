package priv.just1984.deep.in.java.demo.business.factory;

import priv.just1984.deep.in.java.demo.business.enums.ExportType;
import priv.just1984.deep.in.java.demo.business.task.ExportTask;
import priv.just1984.deep.in.java.demo.business.task.OrderExportTask;

import java.util.concurrent.Executor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-29 18:08
 */
public class ExportTaskFactory {

    public static final ExportTaskFactory INSTANCE = new ExportTaskFactory();

    private ExportTaskFactory() {}

    public ExportTask getExportTask(ExportType type, Executor executor) {
        switch (type) {
            case ORDER:
                return new OrderExportTask(executor);
            default:
                throw new IllegalArgumentException();
        }
    }

}
