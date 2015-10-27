package com.personal.controller;

import com.common.utils.JsonUtils;
import com.personal.common.ResultEntity;
import com.personal.entity.Item;
import com.personal.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jaseeka
 * Date 2015/10/27
 * Time 22:41
 */
@Controller
@RequestMapping("/")
public class PlanController {

    @Autowired
    private IPlanService planService;

    /**
     * 获取计划列表
     * @param model
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getPlanList", produces = "application/json;charset=UTF-8")
    public String getPlanList(
            Item model,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();




        return JsonUtils.Object2Json(resultEntity);
    }
}
