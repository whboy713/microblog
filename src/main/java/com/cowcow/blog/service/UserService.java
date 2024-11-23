package com.cowcow.blog.service;

import com.cowcow.blog.entity.User;

public interface UserService {
    //登录
    User login(User user);

    boolean register(User user);

    //根据id查询
    User get(Long id);

    //修改
    void update(User user);
}
