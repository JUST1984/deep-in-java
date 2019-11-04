package priv.just1984.deep.in.java.dubbo.consumer.dubbo.spi;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-04 16:33
 */
public class DubboSpiServiceImpl implements DubboSpiService {

    @Override
    public void doSomething() {
        System.out.println(this.getClass().getName());
    }

}
