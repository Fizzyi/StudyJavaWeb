//package com.springboot.chapter4.plugin;
//
//import com.springboot.chapter4.intercept.Interceptor;
//import com.springboot.chapter4.invoke.Invocation;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Plugin;
//import org.apache.ibatis.plugin.Signature;
//
//import java.lang.reflect.InvocationTargetException;
//import java.sql.Connection;
//import java.util.Properties;
//
//@Intercepts({
//        @Signature(type= StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})
//})
//public class MyPlugin implements Interceptor {
//    Properties properties = null;
//
//   //拦截方法逻辑
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable{
//        System.out.println("插件拦截方法");
//        return invocation.proceed();
//    }
//
//    //生成MyBatis拦截器对象
//    @Override
//    public Object plugin(Object target){
//        return Plugin.wrap(target,this);
//    }
//
//    //设置插件属性
//    @Override
//    public void setProperties(Properties properties){
//        this.properties = properties;
//    }
//
//    @Override
//    public boolean before() {
//        return false;
//    }
//
//    @Override
//    public void after() {
//
//    }
//
//    @Override
//    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
//        return null;
//    }
//
//    @Override
//    public void afterReturning() {
//
//    }
//
//    @Override
//    public void afterThrowing() {
//
//    }
//
//    @Override
//    public boolean useAround() {
//        return false;
//    }
//}
