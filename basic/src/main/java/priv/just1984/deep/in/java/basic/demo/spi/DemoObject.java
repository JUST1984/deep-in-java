package priv.just1984.deep.in.java.basic.demo.spi;

import com.alibaba.fastjson.JSONObject;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-21 11:30
 */
public class DemoObject {

    private Long id;

    private String name;

    private String otherName;

    public void executeByCondition(Consumer<DemoObject> consumer, Predicate<DemoObject> condition) {
        JSONObject obj = null;
        System.out.println(JSONObject.toJSONString(obj));
    }

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        System.out.println(JSONObject.toJSONString(obj));
    }

}
