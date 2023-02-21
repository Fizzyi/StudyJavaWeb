package com.springboot.chapter10;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;


//定义Spring Boot扫描包的路径

@SpringBootApplication(scanBasePackages = {"com.springboot.chapter10"})
//定义JPA接口扫描包路径
//@EnableJpaRepositories(basePackages = "com.springboot.chapter4.dao")
//定义实体Bean扫描包路径
//@EntityScan(basePackages = "com.springboot.chapter.pojo")
//定义MyBatis的扫描
@MapperScan(
        //指定扫描包
        basePackages = "com.springboot.chapter10.*",
        //指定SqlSessionFactory,如果sqlSessionTemplate被指定，则作废
        sqlSessionFactoryRef = "sqlSessionFactory",
        //执行sqlSessionTemplate,将忽略sqlSessionFactory的配置
        sqlSessionTemplateRef = "sqlSessionTemplate",
        //markerInterface = Class.class 限定扫描接口
        annotationClass = Repository.class
)
public class Chapter10Application {

    //启动切面
    public static void main(String[] args) {
        SpringApplication.run(Chapter10Application.class, args);
    }

}
