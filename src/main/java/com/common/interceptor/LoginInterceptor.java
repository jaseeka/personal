package com.common.interceptor;

import com.common.common.Constants;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截
 * Created by jaseeka
 * Date 2015/11/26
 * Time 11:43
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute(Constants.USER_NAME);
        if (user == null) {
            response.setStatus(403);
            logger.debug("state        : " + "403");
            return false;
        }else {
            return super.preHandle(request, response, handler);
        }
    }
}
