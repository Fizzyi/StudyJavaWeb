package com.springboot.chapter4.aspect.service;

import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.aspect.validator.imp1.UserValidatorImp1;
import com.springboot.chapter4.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

// 使用Aspect作为切面声明，
@Aspect
public class MyAspect {
    // 使用注解@Pointcut来定义切点，他标注在方法pointCut上，则在后面的通知注解中就可以使用方法名称来定义了。
    /*
     execution 表示在执行的时候，拦截里面的正则匹配执行的方法
     * 表示任意返回类型的方法
     com.springboot.chapter4.aspect.service.impl.UserServiceImp1 指定目标对象的全限定名称
     printUser 指定目标对象的方法
     (..) 表示任意参数进行匹配
     */
    @DeclareParents(value = "com.springboot.chapter4.aspect.service.impl.UserServiceImp1",
            defaultImpl = UserValidatorImp1.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImp1.printUser(..))")
    public void pointCut() {
    }

    @Before("pointCut() && args()")
    public void before() {
        System.out.println("before ....");
    }

    @Before("pointCut() && args(user)")
    public void beforeParam(JoinPoint point, User user){
        Object[] args = point.getArgs();
        System.out.println("before ....");

    }
    @After("pointCut()")
    public void after() {
        System.out.println("after....");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning....");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing ... ");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before....");
        //回调目标对象的原有方法
        jp.proceed();
        System.out.println("around after....");
    }
}


