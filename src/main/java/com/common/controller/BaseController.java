package com.common.controller;


import com.common.common.Constants;
import com.personal.entity.User;

import javax.servlet.http.HttpSession;

/**
 * Created by jaseeka
 * Date 2015/11/29
 * Time 17:13
 */
public class BaseController {

    /**
     * 获取登录用户
     * @param session
     * @return
     */
    public static User getUser(HttpSession session){
        return (User)session.getAttribute(Constants.USER_NAME);
    }
}
