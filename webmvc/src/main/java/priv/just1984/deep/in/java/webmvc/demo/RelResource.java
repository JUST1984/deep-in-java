package priv.just1984.deep.in.java.webmvc.demo;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-25 16:47
 */
public class RelResource {

    private String prefix;

    public RelResource(String prefix) {
        this.prefix = prefix;
    }

    public Long getResourceId() {
        return invoke("Id", Long.class);
    }

    public String getResourceType() {
        return invoke("Type", String.class);
    }

    private <T> T invoke(String suffix, Class<T> retClz) {
        Method method = ReflectionUtils.findMethod(this.getClass(), "get" + prefix.substring(0, 1).toUpperCase() +
                prefix.substring(1) + suffix);
        try {
            return retClz.cast(method.invoke(this));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
