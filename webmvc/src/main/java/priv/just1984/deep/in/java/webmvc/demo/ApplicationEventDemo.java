package priv.just1984.deep.in.java.webmvc.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-25 16:32
 */
@Slf4j
public class ApplicationEventDemo {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationListenerConfiguration.class);
        context.refresh();
        context.publishEvent(new MyApplicationEvent("hello world"));
        Thread.sleep(3000);
        context.close();
    }

    @Configuration
    public static class ApplicationListenerConfiguration {

        @EventListener(MyApplicationEvent.class)
        public void onMyApplicationEvent(MyApplicationEvent event) {
            log.info(JSONObject.toJSONString(event.getData()));
        }

    }

    @Getter
    @Setter
    private static class MyApplicationEvent extends ApplicationEvent {

        private Object data;

        MyApplicationEvent(Object data) {
            super(data);
            this.data = data;
        }

    }

}
