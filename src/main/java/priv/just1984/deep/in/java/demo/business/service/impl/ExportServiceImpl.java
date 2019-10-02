package priv.just1984.deep.in.java.demo.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.just1984.deep.in.java.demo.business.enums.ExportType;
import priv.just1984.deep.in.java.demo.business.task.ExportTaskFactory;
import priv.just1984.deep.in.java.demo.business.service.ExportService;

import java.io.File;
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
        CompletableFuture<File> completableFuture = CompletableFuture.supplyAsync(ExportTaskFactory.INSTANCE.getExportTask(ExportType.ORDER, executor));
    }

}
