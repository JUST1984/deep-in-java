package priv.just1984.deep.in.java.webmvc.business.manager;

import priv.just1984.deep.in.java.webmvc.business.task.AbstractExportTask;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-27 18:21
 */
public class ExportTaskManager {

    private static final Map<Long, AbstractExportTask> MANAGER;

    static {
        MANAGER = new HashMap<>(1 << 4);
    }

    public static void put(Long exportId, AbstractExportTask abstractExportTask) {
        MANAGER.put(exportId, abstractExportTask);
    }

    public static void remove(Long exportId) {
        MANAGER.remove(exportId);
    }

}
