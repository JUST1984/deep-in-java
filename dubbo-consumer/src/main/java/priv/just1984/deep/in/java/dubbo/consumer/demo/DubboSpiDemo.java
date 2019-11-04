package priv.just1984.deep.in.java.dubbo.consumer.demo;

import org.apache.dubbo.common.extension.ExtensionLoader;
import priv.just1984.deep.in.java.dubbo.consumer.dubbo.spi.DubboSpiService;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-04 16:35
 */
public class DubboSpiDemo {

    public static void main(String[] args) {
        ExtensionLoader<DubboSpiService> extensionLoader = ExtensionLoader.getExtensionLoader(DubboSpiService.class);
        DubboSpiService dubboSpiService = extensionLoader.getExtension("dubboSpiService");
        dubboSpiService.doSomething();
    }

}
