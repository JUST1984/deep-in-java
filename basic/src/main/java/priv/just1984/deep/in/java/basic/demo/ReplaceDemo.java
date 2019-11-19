package priv.just1984.deep.in.java.basic.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-18 20:33
 */
public class ReplaceDemo {

    public static void main(String[] args) {
        Object[] arr = new Object[] {};
        List<Object> objects = Optional.ofNullable(arr).map(Arrays::asList).orElse(new ArrayList<>());
    }

}
