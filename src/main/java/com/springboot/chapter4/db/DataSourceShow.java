package com.springboot.chapter4.db;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


//@Component
//public class DataSourceShow implements ApplicationContextAware {
//    ApplicationContext applicationContext = null;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//        Datasource datasource = applicationContext.getBean(DataSource.class);
//        System.out.println("----------------");
//        System.out.println(datasource.getClass().getName());
//    }
//}
