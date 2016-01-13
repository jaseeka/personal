package com.personal.controller;

import com.common.common.Page;
import com.common.controller.BaseController;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.entity.User;
import com.personal.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jaseeka
 * Date 2016/1/13
 * Time 11:18
 */
@Controller
@RequestMapping("/")
public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "login")
    public String login(
            @RequestParam(value = "number")String number,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        User user = new User();
        user.setPhoneNumber(number);

        PageList<User> userPageList = userService.getListAnd(user, new Page(1, 1));

        if (userPageList == null || userPageList.size() <= 0){
            return "login";
        }else {
            session.setAttribute("user", userPageList.get(0));
            return "jsp/index";
        }
    }
}
