package priv.just1984.deep.in.java.demo.business.factory;

import priv.just1984.deep.in.java.demo.business.task.ExportTask;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-29 18:08
 */
public class ExportTaskFactory {

    public static final ExportTaskFactory INSTANCE = new ExportTaskFactory();

    private ExportTaskFactory() {}

    public ExportTask getExportTask() {
        return null;
    }

}
