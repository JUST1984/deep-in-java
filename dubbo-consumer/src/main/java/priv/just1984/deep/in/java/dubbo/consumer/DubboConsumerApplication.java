package priv.just1984.deep.in.java.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-21 17:30
 */
@EnableDubbo(scanBasePackages = {"priv.just1984.deep.in.java.dubbo.consumer"})
@SpringBootApplication
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

}
