package priv.just1984.deep.in.java.webmvc.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-17 14:12
 */
@Slf4j
@RestController
@RequestMapping("/requestBody")
public class RequestBodyDemo {

    @PostMapping("/list")
    public void list(@RequestBody List<User> userList) {
        log.info(JSONObject.toJSONString(userList));
    }

    @Data
    private static class User {

        private Long id;

        private String name;

    }

}
