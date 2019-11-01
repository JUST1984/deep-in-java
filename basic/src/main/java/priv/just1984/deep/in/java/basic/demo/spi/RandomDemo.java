package priv.just1984.deep.in.java.basic.demo.spi;

import java.util.Random;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-01 17:11
 */
public class RandomDemo {

    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(random.nextInt());
    }

}
