package com.smart.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wzy
 */
@Retention(RetentionPolicy.RUNTIME)  //声明注解的保留期限
@Target(ElementType.METHOD)  //声明可以使用该注解的目标类型
public @interface NeedTest { //定义注解

    //成员注解只有一个变量时必须这样声明
    boolean value() default true; //声明注解成员
}
