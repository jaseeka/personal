package com.personal.controller;

import com.common.common.Page;
import com.common.controller.BaseController;
import com.common.utils.DateUtils;
import com.common.utils.JsonUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.ResultCode;
import com.personal.common.ResultEntity;
import com.personal.common.TypeEnum;
import com.personal.entity.DateItem;
import com.personal.entity.User;
import com.personal.service.IDateItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/7/31.
 */
@RestController
@RequestMapping("/user")
public class DateItemController extends BaseController {

    private static final Logger logger = Logger.getLogger(ItemController.class);

    @Autowired
    private IDateItemService dateItemService;

    /**
     * 获取每日清单列表
     * @param state
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getDateItemList", produces = "application/json;charset=UTF-8")
    public String getDateItemList(
            @RequestParam(value = "state", required = false)Integer state,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        User user = getUser(session);

        DateItem item = new DateItem();
        item.setIsDeleted(false);
        item.setState(state);
        item.setUserId(user.getId());

        Page page = new Page(1, Integer.MAX_VALUE-1, "id", Page.ORDER_ASC);

        PageList<DateItem> itemList = dateItemService.getListAnd(item, page);

        if (itemList != null && itemList.size() > 0){
            resultEntity.getData().put("list", itemList);
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }

        return JsonUtils.Object2Json(resultEntity);
    }

    /**
     * 完成任务
     * @param itemId
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "completeDateItem", produces = "application/json;charset=UTF-8")
    public String completeDateItem(
            @RequestParam(value = "itemId")Integer itemId,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Boolean resule = dateItemService.completeDateItem(itemId);

        if (resule){
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }

        return JsonUtils.Object2Json(resultEntity);
    }

    /**
     * 完成任务
     * @param itemId
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "abandonDateItem", produces = "application/json;charset=UTF-8")
    public String abandonDateItem(
            @RequestParam(value = "itemId")Integer itemId,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Boolean resule = dateItemService.abandonDateItem(itemId);

        if (resule){
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }

        return JsonUtils.Object2Json(resultEntity);
    }

    /**
     * 获取任务数量
     * @param state
     * @param session
     * @param request
     * @param response
     * @return
     */
//    @RequestMapping(value = "getItemCount", produces = "application/json;charset=UTF-8")
//    public String getItemCount(
//            @RequestParam(value = "state")Integer state,
//            HttpSession session,
//            HttpServletRequest request,
//            HttpServletResponse response
//    ){
//        ResultEntity resultEntity = new ResultEntity();
//
//        User user = getUser(session);
//
//        Item item = new Item();
//        item.setIsDeleted(false);
//        item.setState(state);
//        item.setUserId(user.getId());
//
//        Integer total = itemService.count(item);
//
//        if (total != null){
//            resultEntity.getData().put("total", total);
//            resultEntity.setCode(ResultCode.SUCCESS);
//            resultEntity.setMsg(ResultCode.MSUCCESS);
//        }else {
//            resultEntity.setCode(ResultCode.FAILURE);
//            resultEntity.setMsg(ResultCode.MFAILURE);
//        }
//
//        return JsonUtils.Object2Json(resultEntity);
//    }

    /**
     * 添加事项
     * @param content
     * @param time
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "addDateItem", produces = "application/json;charset=UTF-8")
    public String addDateItem(
            @RequestParam(value = "content", required = false)String content,
            @RequestParam(value = "time", required = false)String time,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        User user = getUser(session);

        DateItem item = new DateItem();
        item.setContent(content);
        item.setTime(DateUtils.formateStr(time, "dd-MM-yyyy HH:mm"));
        item.setState(TypeEnum.ItemState.NORMAL.ordinal());
        item.setIsDeleted(false);
        item.setUserId(user.getId());

        Boolean result = dateItemService.add(item) > 0 ? true : false;
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
