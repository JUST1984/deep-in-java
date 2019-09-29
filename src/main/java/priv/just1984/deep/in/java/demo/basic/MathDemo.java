package priv.just1984.deep.in.java.demo.basic;

import java.text.NumberFormat;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-29 17:04
 */
public class MathDemo {

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        System.out.println(numberFormat.format(1f/2f));
        System.out.println(getRate(1234567, 456789));
    }

    private static double getRate(int all, int left) {
        return ((double) all - (double) left) / (double) all;
    }

}
