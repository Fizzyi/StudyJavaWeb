package com.springboot.chapter4.aspect.controller;

import com.springboot.chapter4.aspect.service.UserService;
import com.springboot.chapter4.aspect.service.impl.UserServiceImp1;
import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //定义控制器
@RequestMapping("/user") //定义类请求路径
public class UserController {
    //注入用户服务
    @Autowired
    private UserService userService = null;

    //定义请求
    @RequestMapping("/print")
    //转换为JSON
    @ResponseBody
    public User printUser(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        userService.printUser(user); //若user=null,则执行afterThrowing方法
        return user; //加入断点
    }

    @RequestMapping("/vp")
    @ResponseBody
    public User validateAndPrint(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        // 强制转换
        UserValidator userValidator = (UserValidator) userService;
        //验证用户是否为空
        if (userValidator.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }

    @RequestMapping("/manyAspects")
    @ResponseBody
    private String manyAspects() {
        userService.manyAspects();
        return "manyAspects";
    }
}
