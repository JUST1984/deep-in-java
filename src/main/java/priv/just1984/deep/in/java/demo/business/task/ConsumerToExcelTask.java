package priv.just1984.deep.in.java.demo.business.task;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.extern.slf4j.Slf4j;
import priv.just1984.deep.in.java.demo.business.domain.Exportable;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class ConsumerToExcelTask<T extends Exportable> extends AbstractConsumerTask<T> {

    private ExcelWriter writer;

    private WriteSheet sheet;

    public ConsumerToExcelTask(BlockingQueue queue, CountDownLatch exportCountDown, File file) {
        super(queue, exportCountDown, file);
    }

    @Override
    protected void process(T exportable, File file) {
        try {
            writer.write(Arrays.asList(exportable), sheet);
        } catch (Exception e) {
            log.error("export to excel error", e);
        }
    }

    private void init(T exportable, File file) {
        if (Objects.isNull(writer)) {
            writer = EasyExcel.write(file, exportable.getClass()).build();
        }
        if (Objects.isNull(sheet)) {
            sheet = EasyExcel.writerSheet(UUID.randomUUID().toString()).build();
        }
    }

}
