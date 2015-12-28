package com.personal.controller;

import com.common.common.Page;
import com.common.controller.BaseController;
import com.common.utils.JsonUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.ResultCode;
import com.personal.common.ResultEntity;
import com.personal.entity.RegularDeposit;
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
 * Date 2015/11/16
 * Time 9:54
 */
@RestController
@RequestMapping("/")
public class RegularDepositController extends BaseController {
    @Autowired
    private IRegularDepositService regularDepositService;

    /**
     * 获取定存列表
     * @param model
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getRegularDepositList", produces = "application/json;charset=UTF-8")
    public String getRegularDepositList(
            RegularDeposit model,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Page page = new Page(1,10, "id", Page.ORDER_DESC);
        model.setIsDeleted(false);
        PageList<RegularDeposit> regularDepositList = regularDepositService.getListAnd(model, page);

        if (regularDepositList == null || regularDepositList.size() <= 0){
            resultEntity.setCode(ResultCode.NO_DATA);
            resultEntity.setMsg(ResultCode.MNO_DATA);
        }else {
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
            resultEntity.getData().put("list", regularDepositList);
        }

        return JsonUtils.Object2Json(resultEntity);
    }

    /**
     * 保存定存记录
     * @param id
     * @param content
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "saveRegularDeposit", produces = "application/json;charset=UTF-8")
    public String saveRegularDeposit(
            @RequestParam(value = "id", required = false)Integer id,
            @RequestParam(value = "content")String content,
            @RequestParam(value = "number")Integer number,
            @RequestParam(value = "cycleNum")Integer cycleNum,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        RegularDeposit regularDeposit = new RegularDeposit();
        regularDeposit.setId(id);
        regularDeposit.setContent(content);
        regularDeposit.setNumber(number);
        regularDeposit.setCycleNum(cycleNum);
        regularDeposit.setIsDeleted(false);

        Boolean result = false;
        if (id == null || id <= 0){
            result = regularDepositService.add(regularDeposit) > 0 ? true : false;
        }else {
            result = regularDepositService.update(regularDeposit);
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
     * 删除定存记录
     * @param id
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "deleteRegularDeposit", produces = "application/json;charset=UTF-8")
    public String deleteRegularDeposit(
            @RequestParam(value = "id")Integer id,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        RegularDeposit regularDeposit = new RegularDeposit();
        regularDeposit.setId(id);
        regularDeposit.setIsDeleted(true);

        Boolean result = regularDepositService.update(regularDeposit);

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
