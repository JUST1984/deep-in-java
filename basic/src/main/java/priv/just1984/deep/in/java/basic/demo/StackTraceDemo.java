package priv.just1984.deep.in.java.basic.demo;

import java.util.Arrays;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-14 23:00
 */
public class StackTraceDemo {

    public static void main(String[] args) {
        System.out.println(generateStackTraceInfo());
    }

    private static String generateStackTraceInfo() {
        return Arrays.stream(Thread.currentThread().getStackTrace())
                .collect(StringBuilder::new, (s, e) -> s.append(e.getClassName().concat("#").concat(e.getMethodName())
                                .concat("#").concat(String.valueOf(e.getLineNumber())).concat("\n")),
                        StringBuilder::append).toString();
    }

}
