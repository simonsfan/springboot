package com.simonsfan.cn.exception;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fanrx on 2018/4/24.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(GlobalException.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
        String msg = "";
        if (ex instanceof GlobalException || ex instanceof IndexOutOfBoundsException) {
           msg=((GlobalException) ex).getMsg();
        }else{
            msg = "未知异常";
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
