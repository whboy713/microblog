package com.cowcow.blog.service.impl;

import com.cowcow.blog.entity.User;
import com.cowcow.blog.mapper.UserMapper;
import com.cowcow.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //登录
    //根据用户名查询密码，比较输入密码和数据库密码是否一致
    @Override
    public User login(User user) {
        String username = user.getUsername();
        User selectUser = userMapper.loginUser(username);
        if(selectUser != null) {
            String inputPass = user.getPassword();
            String databasePass = selectUser.getPassword();
            if(!inputPass.equals(databasePass)) {
                return null;
            }
            return selectUser;
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        //根据用户名查询，如果存在相同的，不能注册
        User selectUser = userMapper.loginUser(user.getUsername());
        if(selectUser == null) {
            //注册
            userMapper.insertUser(user);
            return true;
        }
        return false;
    }

    //根据id查询
    @Override
    public User get(Long id) {
        return userMapper.getUser(id);
    }

    //修改
    @Override
    public void update(User user) {
        userMapper.updateUser(user);
    }
}