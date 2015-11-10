package com.personal.controller;

import com.common.utils.JsonUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.Page;
import com.personal.common.ResultCode;
import com.personal.common.ResultEntity;
import com.personal.entity.Item;
import com.personal.entity.Plan;
import com.personal.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jaseeka
 * Date 2015/10/27
 * Time 22:41
 */
@RestController
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
            Plan model,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Page page = new Page();
        PageList<Plan> planList = planService.getList(model, page);

        if (planList == null || planList.size() <= 0){
            resultEntity.setCode(ResultCode.NO_DATA);
            resultEntity.setMsg(ResultCode.MNO_DATA);
        }else {
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
            resultEntity.getData().put("list", planList);
        }

        return JsonUtils.Object2Json(resultEntity);
    }

    /**
     * 保存计划
     * @param id
     * @param content
     * @param isCycle
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "savePlan", produces = "application/json;charset=UTF-8")
    public String savePlan(
            @RequestParam(value = "id", required = false)Integer id,
            @RequestParam(value = "content")String content,
            @RequestParam(value = "isCycle")Boolean isCycle,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Plan plan = new Plan();
        plan.setId(id);
        plan.setContent(content);
        plan.setIsCycle(isCycle);

        Boolean result = false;
        if (id == null || id <= 0){
            result = planService.insert(plan) > 0 ? true : false;
        }else {
            result = planService.update(plan);
        }

        if (result){
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.NO_DATA);
            resultEntity.setMsg(ResultCode.MNO_DATA);
        }

        return JsonUtils.Object2Json(resultEntity);
    }
}
