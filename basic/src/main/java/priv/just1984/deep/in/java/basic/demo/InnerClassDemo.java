package priv.just1984.deep.in.java.basic.demo;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-19 14:34
 */
public class InnerClassDemo {

    public static void main(String[] args) {
        InnerClassDemo demo = new InnerClassDemo();
        // Inner inner = demo.new Inner();
        Inner inner = new Inner();
        Field[] declaredFields = inner.getClass().getDeclaredFields();
        System.out.println(Arrays.stream(declaredFields).map(field -> field.getType().toString()).collect(Collectors.joining("\n")));
    }

    private static class Inner {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
