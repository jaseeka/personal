package com.common.filter;

import com.common.common.Constants;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jaseeka
 * Date 2016/1/13
 * Time 12:01
 */
public class LoginFilter implements Filter {

    Logger logger = Logger.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        Object user = request.getSession().getAttribute(Constants.USER_NAME);
        if (user == null) {
            response.setStatus(403);
            response.sendRedirect("../login.jsp");
        }else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
