package priv.just1984.deep.in.java.webmvc.customize.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-22 19:21
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestBodyDecoder {
}
