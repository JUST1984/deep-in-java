package priv.just1984.deep.in.java.basic.demo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-01 10:52
 */
public class SpiDemo {

    public static void main(String[] args) {
        ServiceLoader<Eat> eatServices = ServiceLoader.load(Eat.class);
        Iterator<Eat> iterator = eatServices.iterator();
        while (iterator.hasNext()) {
            Eat eat = iterator.next();
            eat.eat();
        }
    }
}
