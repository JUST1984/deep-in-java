package priv.just1984.deep.in.java.basic.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-17 16:01
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("-10");
        BigDecimal c = a.add(b);
        System.out.println(c);
    }

}
