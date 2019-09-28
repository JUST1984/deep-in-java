package priv.just1984.deep.in.java.demo.business.manager;

import priv.just1984.deep.in.java.demo.business.task.ExportTask;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-27 18:21
 */
public class ExportTaskManager {

    private static final Map<Long, ExportTask> MANAGER;

    static {
        MANAGER = new HashMap<>(1 << 4);
    }

    public static void put(Long exportId, ExportTask exportTask) {
        MANAGER.put(exportId, exportTask);
    }

    public static void remove(Long exportId) {
        MANAGER.remove(exportId);
    }

}
