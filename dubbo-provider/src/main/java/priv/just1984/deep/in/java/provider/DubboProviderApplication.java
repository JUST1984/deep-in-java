package priv.just1984.deep.in.java.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-21 17:32
 */
@EnableDubbo(scanBasePackages = {"priv.just1984.deep.in.java.provider.service"})
@SpringBootApplication
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }

}
