package net.bcdmw.base_project.service.Impl;

import net.bcdmw.base_project.mapper.UserMapper;
import net.bcdmw.base_project.service.UserService;
import net.bcdmw.base_project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id=user.getId();
        return id;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public int addAccount() {
        User user=new User();
        user.setAge(33);
        user.setCreateTime(new Date());
        user.setName("测试事物123");
        user.setPhone("99999");
        int id=userMapper.insert(user);
        int i=9/0;
        return 0;
    }
}
