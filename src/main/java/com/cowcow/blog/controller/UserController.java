package com.cowcow.blog.controller;

import com.cowcow.blog.entity.User;
import com.cowcow.blog.service.UserService;
import com.cowcow.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @PostMapping("login")
    public Result loginUser(@RequestBody User user) {
        User userExist = userService.login(user);
        if(userExist != null) {
            Map<String,Object> map = new HashMap<>();
            map.put("name",userExist.getUsername());
            map.put("uid",userExist.getUid());
            return Result.ok(map);
        } else {
            return Result.fail();
        }
    }

    //注册
    @PostMapping("register")
    public Result registerUser(@RequestBody User user) {
        boolean flag = userService.register(user);
        if(flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //根据id查询
    @GetMapping("getUser/{id}")
    public Result getUser(@PathVariable Long id) {
        User user = userService.get(id);
        return Result.ok(user);
    }

    //修改
    @PutMapping("updateUser")
    public Result updateUser(@RequestBody User user) {
        userService.update(user);
        return Result.ok();
    }


}
