package com.simonsfan.cn.exception;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by fanrx on 2018/4/24.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(GlobalException.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        if (ex instanceof IndexOutOfBoundsException) {
            GlobalException global = new GlobalException("我是全局异常处理器");
            log.info("Global exception handler exception="+global.getMessage());
            System.out.println(("Global exception handler exception="+global.getMessage()));
            return "error";
        }
        return null;
    }

}
