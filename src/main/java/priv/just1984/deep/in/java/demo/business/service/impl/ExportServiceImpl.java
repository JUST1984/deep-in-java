package priv.just1984.deep.in.java.demo.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.just1984.deep.in.java.demo.business.enums.ExportType;
import priv.just1984.deep.in.java.demo.business.service.ExportService;
import priv.just1984.deep.in.java.demo.business.task.ExportTaskFactory;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-27 17:13
 */
@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    private Executor executor;

    @Override
    public void export() {
        CompletableFuture.supplyAsync(ExportTaskFactory.INSTANCE.getExportTask(ExportType.ORDER, executor))
                .whenComplete((file, ex) -> {
                    if (Objects.isNull(ex)) {
                        // 成功处理
                    } else {
                        // 失败处理
                    }
                });
    }

}
