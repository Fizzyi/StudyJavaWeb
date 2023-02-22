package com.springboot.chapter11.controller;

import com.springboot.chapter11.enumeration.SexEnum;
import com.springboot.chapter11.pojo.User;
import com.springboot.chapter11.service.UserService;
import com.springboot.chapter11.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@RestController //默认使用JSON视图
public class UserController {
    //用户服务接口
    @Autowired
    private UserService userService = null;

    //映射JSP视图
    @GetMapping("/restful")
    public String index() {
        return "restful";
    }

    //转换Vo变为Po
    private User changeToPo(UserVo userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setUserName(userVo.getUserName());
        user.setSex(SexEnum.getSexEnum(userVo.getSexCode()));
        user.setNote(userVo.getNote());
        return user;
    }

    //转换Po变为VO
    private UserVo changeToVo(User user) {
        UserVo uservo = new UserVo();
        uservo.setId(user.getId());
        uservo.setUserName(user.getUserName());
        uservo.setSexCode(user.getSex().getCode());
        uservo.setSexName(user.getSex().getName());
        uservo.setNote(user.getNote());
        return uservo;

    }

    //将Po列表转换为VO列表
    private List<UserVo> changeToVoes(List<User> poList) {
        List<UserVo> voList = new ArrayList<>();
        for (User user : poList) {
            UserVo userVo = changeToVo(user);
            voList.add(userVo);
        }
        return voList;
    }

    //结果VO
    public class ResultVo {
        private Boolean success = null;
        private String message = null;

        public ResultVo() {
        }

        public ResultVo(Boolean success, String message) {
            this.success = success;
            this.message = message;
        }
    }

    @PostMapping("/user")
    public int insertUser(@RequestBody UserVo userVo) {
        User user = this.changeToPo(userVo);
        return userService.insertUser(user);
    }

    //根据ID查询用户
    @GetMapping(value = "/user/{id}")
    public UserVo getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return changeToVo(user);
    }

    //根据其他条件查询用户
    @GetMapping("/users/{userName}/{note}/{start}/{limit}")
    public List<UserVo> findUsers(@PathVariable("userName") String userName,
                                  @PathVariable("note") String note,
                                  @PathVariable("start") int start,
                                  @PathVariable("limit") int limit) {
        List<User> userList = userService.findUsers(userName, note, start, limit);
        return this.changeToVoes(userList);
    }

    //使用put修改用户信息
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody UserVo userVo) {
        User user = this.changeToPo(userVo);
        user.setId(id);
        userService.updateUser(user);
        return user;
    }

    //使用PATCH请求修改用户名称
    @PatchMapping("/user/{id}/{userName}")
    public ResultVo changeUserName(@PathVariable("id") Long id, @PathVariable("userName") String userName) {
        int result = userService.updateUserName(id, userName);
        return new ResultVo(result > 0, result > 0 ? "更新成功" : "更新用户【" + id + "】失败。");
    }

    //使用Delete删除数据
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public ResultVo deleteUser(@PathVariable("id") Long id) {
        int result = userService.deleteUser(id);
        return new ResultVo(result > 0, result > 0 ? "更新成功" : "更新用户【" + id + "】失败");
    }
}
