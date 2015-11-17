package com.common.filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 测试数据打印
 * Created by jaseeka
 * Date 2015/11/17
 * Time 14:51
 */
public class DebugFilter implements Filter {
    Logger logger = Logger.getLogger(DebugFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String sessionId = request.getSession().getId();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null){
            ipAddress = request.getRemoteAddr();
        }
        String url = request.getRequestURL().toString();

        if (!url.endsWith(".css") && !url.endsWith(".js")) {
            // 输出测试信息
            logger.debug("================================================================");
            logger.debug("session        : " + sessionId);
            logger.debug("ip             : " + ipAddress);
            logger.debug("url            : " + url);
            logger.debug("================================================================\r\n");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
