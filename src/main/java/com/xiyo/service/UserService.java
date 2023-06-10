package com.xiyo.service;

import com.xiyo.domain.User;

import java.util.List;

public interface UserService {
    User checkLogin(User user);

    boolean checkName(User user);

    void changeUser(User user);

    List<User> checkAllUser();

//    void addUser(User user);


}
