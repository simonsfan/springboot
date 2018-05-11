package com.simonsfan.cn.exception;

/**
 * Created by fanrx on 2018/4/24.
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

  /*  private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

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
*/
}
