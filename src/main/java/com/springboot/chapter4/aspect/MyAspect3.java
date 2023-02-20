package com.springboot.chapter4.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect3 {
    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImp1.manyAspects(..))")
    public void manyAspects() {
    }

    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect3 before....");
    }

    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect3 after ....");
    }

    @After("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect3 afterReturning");
    }
}
