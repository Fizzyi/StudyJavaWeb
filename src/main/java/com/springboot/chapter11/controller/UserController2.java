package com.springboot.chapter11.controller;

import com.springboot.chapter11.enumeration.SexEnum;
import com.springboot.chapter11.service.UserService;
import com.springboot.chapter11.vo.UserVo;
import com.springboot.chapter11.pojo.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {
    private UserService userService = null;

    private UserVo changeToVo(com.springboot.chapter11.pojo.User user) {
        UserVo uservo = new UserVo();
        uservo.setId(user.getId());
        uservo.setUserName(user.getUserName());
        uservo.setSexCode(user.getSex().getCode());
        uservo.setSexName(user.getSex().getName());
        uservo.setNote(user.getNote());
        return uservo;

    }

    private com.springboot.chapter11.pojo.User changeToPo(UserVo userVo) {
        com.springboot.chapter11.pojo.User user = new com.springboot.chapter11.pojo.User();
        user.setId(userVo.getId());
        user.setUserName(userVo.getUserName());
        user.setSex(SexEnum.getSexEnum(userVo.getSexCode()));
        user.setNote(userVo.getNote());
        return user;
    }

    @PostMapping("/user2/entity")
    public ResponseEntity<UserVo> insertUserEntity(
            @RequestBody UserVo userVo) {
        User user = this.changeToPo(userVo);
        userService.insertUser(user);
        UserVo result = this.changeToVo(user);
        HttpHeaders headers = new HttpHeaders();
        String success = (result == null || result.getId() == null) ? "false" : "true";
        //设置响应头,比较常用的方法
        headers.add("success", success);
        return new ResponseEntity<UserVo>(result, headers, HttpStatus.CREATED);

    }

    @PostMapping(value = "/user2/annotation")
    @ResponseStatus(HttpStatus.CREATED) // 指定状态码为201 资源创建成功
    public UserVo insertUserAnnotation(@RequestBody UserVo userVo) {
        User user = this.changeToPo(userVo);
        userService.insertUser(user);
        UserVo result = this.changeToVo(user);
        return this.changeToVo(user);
    }

}
