package priv.just1984.deep.in.java.dubbo.api.service;

import priv.just1984.deep.in.java.dubbo.api.vo.User;

import java.util.List;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-21 17:40
 */
public interface UserService {

    void add(User user);

    List<User> getAll();

}
