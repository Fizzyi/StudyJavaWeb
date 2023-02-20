package com.springboot.chapter4.pojo;

import com.springboot.chapter4.enumeration.SexEnum;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component 注解标明这个类将被Spring IoC容器扫描装配，其中配置的"user"则是做为bean的名称，
// 如果不配置，那么IoC容器将会把类名第一个字母作为小写，其他不变作为Bean名称放入到IoC容器中；
// 注解@Value则是指定具体的值，是的IoC给予对应的属性注入对应的值。初始值？
@Alias(value = "user") //MyBatis指定别名
public class User {

    private Long id;
    private String userName;
    private String note;
    private SexEnum sex = null; //枚举

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public SexEnum getSex() {
        return sex;
    }
}
