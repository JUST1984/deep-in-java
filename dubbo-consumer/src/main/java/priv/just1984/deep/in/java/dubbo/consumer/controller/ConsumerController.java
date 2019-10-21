package priv.just1984.deep.in.java.dubbo.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.just1984.deep.in.java.dubbo.api.service.UserService;
import priv.just1984.deep.in.java.dubbo.api.vo.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-21 17:54
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private UserService userService;

    @RequestMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

}
