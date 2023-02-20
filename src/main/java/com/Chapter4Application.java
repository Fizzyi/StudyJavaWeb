package com;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;


//定义Spring Boot扫描包的路径

@SpringBootApplication(scanBasePackages = {"com.springboot.chapter4"})
//定义JPA接口扫描包路径
//@EnableJpaRepositories(basePackages = "com.springboot.chapter4.dao")
//定义实体Bean扫描包路径
//@EntityScan(basePackages = "com.springboot.chapter.pojo")
//定义MyBatis的扫描
@MapperScan(
        //指定扫描包
        basePackages = "com.springboot.chapter4.*",
        //指定SqlSessionFactory,如果sqlSessionTemplate被指定，则作废
        sqlSessionFactoryRef = "sqlSessionFactory",
        //执行sqlSessionTemplate,将忽略sqlSessionFactory的配置
        sqlSessionTemplateRef = "sqlSessionTemplate",
        //markerInterface = Class.class 限定扫描接口
        annotationClass = Repository.class
)
public class Chapter4Application {

    //启动切面
    public static void main(String[] args) {
        SpringApplication.run(Chapter4Application.class, args);
    }

    //注入事务管理器，它由Spring Boot自动生成
    @Autowired
    PlatformTransactionManager transactionManager = null;

    //使用后初始化方法，观察自动生成的事务管理器
    @PostConstruct
    public void viewTransactionManager() {
        //启动前加入断点观测
        System.out.println(transactionManager.getClass().getName());
    }
}
