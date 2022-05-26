package com.example.annotation;

import java.lang.annotation.*;
import java.time.temporal.ValueRange;

/**
 * @author zxy
 * @Classname Annotation
 * @Date 2022/4/23 13:41
 */
@MyAnnotation("傻逼毒瘤")
public class Annotation {

    @MyAnnotation(name="傻呗",value = "hhh")
    public void test(){

    }

}
