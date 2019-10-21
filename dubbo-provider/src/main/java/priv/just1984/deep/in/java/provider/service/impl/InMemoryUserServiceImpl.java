package priv.just1984.deep.in.java.provider.service.impl;

import org.apache.dubbo.config.annotation.Service;
import priv.just1984.deep.in.java.dubbo.api.service.UserService;
import priv.just1984.deep.in.java.dubbo.api.vo.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-21 17:42
 */
@Service
public class InMemoryUserServiceImpl implements UserService {

    private static final List<User> users = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

}
