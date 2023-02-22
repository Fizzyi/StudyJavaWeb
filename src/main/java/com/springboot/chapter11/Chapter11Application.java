package com.springboot.chapter11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//定义Spring Boot扫描包的路径

@SpringBootApplication(scanBasePackages = {"com.springboot.chapter11"})
//定义JPA接口扫描包路径
//@EnableJpaRepositories(basePackages = "com.springboot.chapter4.dao")
//定义实体Bean扫描包路径
//@EntityScan(basePackages = "com.springboot.chapter.pojo")
//定义MyBatis的扫描
@MapperScan(
        //指定扫描包
        basePackages = "com.springboot.chapter11.*",
        //指定SqlSessionFactory,如果sqlSessionTemplate被指定，则作废
        sqlSessionFactoryRef = "sqlSessionFactory",
        //执行sqlSessionTemplate,将忽略sqlSessionFactory的配置
        sqlSessionTemplateRef = "sqlSessionTemplate",
        //markerInterface = Class.class 限定扫描接口
        annotationClass = Repository.class
)
public class Chapter11Application implements WebMvcConfigurer {

    //启动切面
    public static void main(String[] args) {
        SpringApplication.run(Chapter11Application.class, args);
    }


}
