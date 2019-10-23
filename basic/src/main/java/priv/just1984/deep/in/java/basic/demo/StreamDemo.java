package priv.just1984.deep.in.java.basic.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-30 16:33
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<A> aList = new ArrayList<>();
        List<B> bList = new ArrayList<>();
        List<C> res = aList.stream().filter(a -> !bList.contains(a)).map(C::ofA).collect(Collectors.toList());
    }

    @Data
    private static class A {

        private Long id;

        private String type;

    }

    @Data
    @AllArgsConstructor
    private static class B {

        private Long id;

        private String type;

        @Override
        public boolean equals(Object o) {
            if (o instanceof A) {
                return this.equals(ofA(A.class.cast(o)));
            }
            // ...
            return false;
        }

        public static B ofA(A a) {
            return new B(a.getId(), a.getType());
        }

    }

    @Data
    @AllArgsConstructor
    private static class C {

        private Long id;

        private String type;

        public static C ofA(A a) {
            return new C(a.getId(), a.getType());
        }

    }

}
