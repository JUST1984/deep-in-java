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
        String res = BigDecimal.valueOf(6100).divide(BigDecimal.valueOf(200), 0, RoundingMode.CEILING).toString();
        System.out.println(res);
    }

}
