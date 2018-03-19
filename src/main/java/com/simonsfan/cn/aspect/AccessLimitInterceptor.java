package com.simonsfan.cn.aspect;

import com.simonsfan.cn.redis.AccessKey;
import com.simonsfan.cn.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by fanrx on 2018/3/11.
 */
@Component
public class AccessLimitInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            /*Method method = handlerMethod.getMethod();
            if(!method.isAnnotationPresent(AccessLimit.class)){
                return true;
            }*/
            AccessLimit accessLimit = handlerMethod.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int limit = accessLimit.limit();
            int seconds = accessLimit.seconds();
            AccessKey accessKey = AccessKey.withExpire(seconds);
            String requestURI = request.getRequestURI();
            Integer maxAccess = redisService.get(accessKey, ":"+requestURI, Integer.class);
            if (maxAccess == null) {
                redisService.set(accessKey, ":"+requestURI, 1);
            } else if (maxAccess < limit) {
                redisService.incr(accessKey, ":"+requestURI);
            } else {
                commonRender(response, "访问太频繁！");
                return false;
            }
        }
        return true;
    }

    private void commonRender(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            out.write(msg.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }


}
