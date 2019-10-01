package priv.just1984.deep.in.java.demo.business.consumer;

import priv.just1984.deep.in.java.demo.business.domain.ExportableOrder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ExportableOrderConsumer extends ExportableConsumer<ExportableOrder> {

    public ExportableOrderConsumer(BlockingQueue<ExportableOrder> queue, CountDownLatch exportCountDown) {
        super(queue, exportCountDown);
    }

    @Override
    protected void process(ExportableOrder exportable) {

    }

}
