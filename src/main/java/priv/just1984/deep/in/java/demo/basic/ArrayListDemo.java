package priv.just1984.deep.in.java.demo.basic;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list = Stream.iterate("0", s -> String.valueOf(Integer.valueOf(s) + 1)).limit(100000).collect(Collectors.toList());
        Instant start = Instant.now();
        int size = list.size();
        /*for (int i = 0; i < size; i++) {
            list.remove(i);
        }*/
        /*for (int i = size - 1; i >=0; i--) {
            list.remove(i);
        }*/
        /*for (String s : list) {
            list.remove(s);
        }*/
        /*iterator.remove();
        for (int i = 0; i < 10001; i++) {
            iterator.next();
        }*/
        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }*/
        System.out.println(list.size());
        System.out.printf("耗时：【%s】", Duration.between(start, Instant.now()).toMillis());
    }

}
