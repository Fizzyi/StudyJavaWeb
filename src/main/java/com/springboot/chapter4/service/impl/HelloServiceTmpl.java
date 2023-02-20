package com.springboot.chapter4.service.impl;

import com.springboot.chapter4.service.HelloService;

public class HelloServiceTmpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException("parameter is null");
        }
        System.out.println("hello" + name);
    }
}

