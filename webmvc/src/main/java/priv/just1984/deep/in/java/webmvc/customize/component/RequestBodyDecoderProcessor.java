package priv.just1984.deep.in.java.webmvc.customize.component;

import com.alibaba.fastjson.JSONObject;
import lombok.NoArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import priv.just1984.deep.in.java.webmvc.customize.annotation.RequestBodyDecoder;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-22 19:26
 */
@NoArgsConstructor
public class RequestBodyDecoderProcessor implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestBodyDecoder.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (webRequest instanceof ServletWebRequest) {
            ServletWebRequest request = ServletWebRequest.class.cast(webRequest);
            HttpServletRequest httpServletRequest = request.getRequest();
            ServletInputStream inputStream = httpServletRequest.getInputStream();
            Map<String, Object> bodyMap = JSONObject.parseObject(inputStream, Map.class);
            System.out.println(bodyMap);
        }
        return null;
    }

}
