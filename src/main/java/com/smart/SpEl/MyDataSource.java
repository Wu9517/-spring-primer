package com.smart.SpEl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @Value注解可以标注在类的属性、方法及构造器上，用于从配置文件中加载一个参数值,对应SpEL_test.properties文件， 其中的值可以在配置文件中通过${field}的方式访问到
 */
@Component
public class MyDataSource {
    @Value("${name}")
    private String name;

    @Value("${gender}")
    private String gender;

    @Value("${age}")
    private Integer age;

}
