package priv.just1984.deep.in.java.basic.demo;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-30 16:33
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Item> sources = new ArrayList<>();
        Map<String, List<Item>> map = sources.stream().collect(Collectors.groupingBy(Item::getTypeId));
        List<Item> res = map.values().stream().map(list -> list.stream()
                .min(Comparator.comparingInt(Item::getExpireType).thenComparing(Item::getExpireTime, Comparator.reverseOrder()))
                .get()).collect(Collectors.toList());


        /*Stream<Stream<Integer>> stream = Stream.of(Stream.of(1, 2, 3), Stream.of(4, 5, 6), Stream.of(7, 8, 9));
        Stream<Integer> res = stream.flatMap(Function.identity());
        res.forEach(System.out::print);*/
    }

    @Data
    private static class Item {

        private String typeId;

        private int expireType;

        private Date expireTime;

    }

}
