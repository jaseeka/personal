package com.personal.controller;

import com.common.common.Page;
import com.common.controller.BaseController;
import com.common.utils.JsonUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.ResultCode;
import com.personal.common.ResultEntity;
import com.personal.entity.Plan;
import com.personal.entity.User;
import com.personal.service.IPlanService;
import com.personal.service.IRegularDepositService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/user")
public class PlanController extends BaseController{

    @Autowired
    private IPlanService planService;
    @Autowired
    private IRegularDepositService regularDepositService;

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

        User user = getUser(session);
        model.setUserId(user.getId());

        Page page = new Page();
        PageList<Plan> planList = planService.getListAnd(model, page);

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
     * @param cycleNum
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "savePlan", produces = "application/json;charset=UTF-8")
    public String savePlan(
            @RequestParam(value = "id", required = false)Integer id,
            @RequestParam(value = "content")String content,
            @RequestParam(value = "cycleNum")Integer cycleNum,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Plan plan = new Plan();
        plan.setId(id);
        plan.setContent(content);
        plan.setCycleNum(cycleNum);

        Boolean result = false;
        if (id == null || id <= 0){
            User user = getUser(session);
            plan.setUserId(user.getId());
            result = planService.add(plan) > 0 ? true : false;
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


    /**
     * 删除计划
     * @param planId
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "deletePlan", produces = "application/json;charset=UTF-8")
    public String deletePlan(
            @RequestParam(value = "planId")Integer planId,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Boolean result = planService.deleteById(planId);

        if (result){
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.NO_DATA);
            resultEntity.setMsg(ResultCode.MNO_DATA);
        }

        return JsonUtils.Object2Json(resultEntity);
    }

    /**
     * 执行定时任务
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "addPlanItem", produces = "application/json;charset=UTF-8")
    public String addPlanItem(
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Boolean result = planService.addCyclePlan();
        regularDepositService.addCycleMoney();


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
