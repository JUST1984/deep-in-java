package priv.just1984.deep.in.java.webmvc.business.task;

import priv.just1984.deep.in.java.webmvc.business.enums.ExportType;

import java.util.concurrent.Executor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-29 18:08
 */
public class ExportTaskFactory {

    public static final ExportTaskFactory INSTANCE = new ExportTaskFactory();

    private ExportTaskFactory() {}

    public AbstractExportTask<?> getExportTask(ExportType type, Executor executor) {
        switch (type) {
            case ORDER:
                return new OrderExportTask(executor);
            default:
                throw new IllegalArgumentException();
        }
    }

}
