package com.springboot.chapter4.aspect.validator.imp1;

import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.pojo.User;

public class UserValidatorImp1 implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口：" + UserValidator.class.getSimpleName());
        return user != null;
    }
}
