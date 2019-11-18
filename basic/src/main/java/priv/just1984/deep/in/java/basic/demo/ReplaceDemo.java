package priv.just1984.deep.in.java.basic.demo;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-18 20:33
 */
public class ReplaceDemo {

    public static void main(String[] args) {
        String origin  = ReplaceDemo.class.getName();
        System.out.println(origin.replaceAll("\\.", "/"));
    }

}
