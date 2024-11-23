package com.cowcow.blog.mapper;

import com.cowcow.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    //登录
    User loginUser(String username);

    //注册
    void insertUser(User user);

    //根据id查询
    User getUser(Long id);

    //修改
    void updateUser(User user);
}
