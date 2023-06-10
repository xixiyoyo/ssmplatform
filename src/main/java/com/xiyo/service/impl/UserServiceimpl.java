package com.xiyo.service.impl;

import com.xiyo.dao.UserMapper;
import com.xiyo.domain.User;
import com.xiyo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkLogin(User user) {
        return userMapper.isLogin(user);
    }

    @Override
    public boolean checkName(User user) {
        User user1 = userMapper.isname1(user.getUname());
        if(user1 == null){
            userMapper.isName(user);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public void changeUser(User user) {
        userMapper.alterUser(user);
    }

    @Override
    public List<User> checkAllUser() {
        return userMapper.checkAllUser();
    }

//    @Override
//    public void addUser(User user) {
//        userMapper.
//    }
}
