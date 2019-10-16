package priv.just1984.deep.in.java.basic.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-30 16:33
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        boolean res = list.stream().collect(Collectors.toMap(x -> x, x -> 1, (x, y) -> x + 1))
                .values().stream().anyMatch(x -> x > 1);

        System.out.println(res);

        boolean res2 = list.stream().distinct().count() < list.size();

        System.out.println(res2);

    }

}
