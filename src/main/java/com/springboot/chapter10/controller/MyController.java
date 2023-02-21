package com.springboot.chapter10.controller;

import com.springboot.chapter10.pojo.User;
import com.springboot.chapter10.pojo.ValidatorPojo;
import com.springboot.chapter10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/my")
@Controller
public class MyController {
    @Autowired
    public UserService userService = null;

    /*
     * 在无注解下获取参数，要求参数名称和HTTP请求参数名称一致
     * @param inVal -- 整数
     * @param longVal -- 长整型
     * @param str --字符串
     * @return 响应JSON参数
     */
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String, Object> noAnnotation(Integer intVal, Long longVal, String str) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intval", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("str", str);
        return paramsMap;
    }

    /*
     * 通过注解@RequestParam获取参数,默认情况下不能为空，可以通过配置属性required=false为空。
     * @param inVal -- 整数
     * @param longVal -- 长整型
     * @param str --字符串
     * @return 响应JSON参数
     * */
    @GetMapping("/annotation")
    @ResponseBody
    public Map<String, Object> annotation(@RequestParam("int_val") Integer intVal,
                                          @RequestParam("long_val") Long longVal,
                                          @RequestParam(value = "str_val", required = false) String strVal) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intval", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("str", strVal);
        return paramsMap;

    }

    //传递数据
    @GetMapping("/requestArray")
    @ResponseBody
    public Map<String, Object> requestArray(int[] intArr, Long[] longArr, String[] strArr) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intval", intArr);
        paramsMap.put("longVal", longArr);
        paramsMap.put("str", strArr);
        return paramsMap;
    }


    /*
     *新增用户
     * @param user 通过@RequestBody注解得到JSON参数
     * @return 回填id后的用户信息
     * */
    @PostMapping("/insert")
    @ResponseBody
    public User insert(@RequestBody User user) {
        userService.insertUser(user);
        return user;
    }

    /*
     * 通过URL传递参数
     * 通过处理器映射可以定位参数的位置和名称
     * 使用注解@pathVariable可以通过名称来获取参数
     *
     * */
    @GetMapping("/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/valid/validate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> validate(@Valid @RequestBody ValidatorPojo vp, Errors errors) {
        Map<String, Object> errMap = new HashMap<>();
        //获取错误列表
        List<ObjectError> oes = errors.getAllErrors();
        for (ObjectError oe : oes) {
            String key = null;
            String msg = null;
            //字段错误
            if (oe instanceof FieldError) {
                FieldError fe = (FieldError) oe;
                key = fe.getField();//获取错误验证字段名
            } else {
                //非字段错误
                key = oe.getObjectName();//获取验证对象名称

            }
            //错误信息
            msg = oe.getDefaultMessage();
            errMap.put(key, msg);
        }
        return errMap;
    }
}
