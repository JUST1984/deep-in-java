package priv.just1984.deep.in.java.basic.demo;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-18 20:21
 */
public class MethodDemo {

    public void method() {}

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = MethodDemo.class.getDeclaredMethod("method");
        System.out.println(method.getDeclaringClass().getName());
    }

}
