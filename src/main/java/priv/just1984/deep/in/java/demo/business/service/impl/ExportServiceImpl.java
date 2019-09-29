package priv.just1984.deep.in.java.demo.business.service.impl;

import org.springframework.stereotype.Service;
import priv.just1984.deep.in.java.demo.business.service.ExportService;
import priv.just1984.deep.in.java.demo.business.task.ExportTask;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-27 17:13
 */
@Service
public class ExportServiceImpl implements ExportService {

    @Override
    public void export() {
        /*CompletableFuture<Void> future = CompletableFuture.runAsync(new ExportTask<>());
        future.whenComplete()*/
    }

}
