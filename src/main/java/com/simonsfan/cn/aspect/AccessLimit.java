package com.simonsfan.cn.aspect;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLimit {

    int limit();  //次数

    int seconds();  //时间(s)

}
