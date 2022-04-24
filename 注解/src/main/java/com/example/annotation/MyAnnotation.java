package com.example.annotation;

import java.lang.annotation.*;

// 定义一个注解
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{
    // 注解的参数：参数类型 +参数名();
    String name() default "";
    String value();
}