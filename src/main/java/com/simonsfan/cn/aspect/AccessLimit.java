package com.simonsfan.cn.aspect;

import java.lang.annotation.*;

/**
 * Created by fanrx on 2018/3/11.
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLimit {

    int limit();  //次数

    int seconds();  //时间(s)

}
