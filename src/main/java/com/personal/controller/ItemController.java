package com.personal.controller;

import com.common.utils.JsonUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.ResultCode;
import com.personal.common.ResultEntity;
import com.personal.common.TypeEnum;
import com.personal.entity.Item;
import com.personal.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jaseeka
 * Date 2015/9/24
 * Time 21:14
 */
@RestController
@RequestMapping("/")
public class ItemController {

    @Autowired
    private IItemService itemService;

    /**
     * 获取事项列表
     * @param state
     * @param model
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getItemList", produces = "application/json;charset=UTF-8")
    public String getItemList(
            @RequestParam(value = "state")Integer state,
            Item model,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Item item = new Item();
        item.setIsDeleted(false);
        item.setState(state);

        PageList<Item> itemList = itemService.getList(item, null);

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
     * @param model
     * @param itemId
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "completeItem", produces = "application/json;charset=UTF-8")
    public String completeItem(
            Item model,
            @RequestParam(value = "itemId")Integer itemId,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Boolean resule = itemService.completeItem(itemId);

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
     * @param model
     * @param itemId
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "abandonItem", produces = "application/json;charset=UTF-8")
    public String abandonItem(
            Item model,
            @RequestParam(value = "itemId")Integer itemId,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Boolean resule = itemService.abandonItem(itemId);

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
     * @param model
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getItemCount", produces = "application/json;charset=UTF-8")
    public String getItemCount(
            @RequestParam(value = "state")Integer state,
            Item model,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Item item = new Item();
        item.setIsDeleted(false);
        item.setState(state);

        Integer total = itemService.count(item);

        if (total != null){
            resultEntity.getData().put("total", total);
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }

        return JsonUtils.Object2Json(resultEntity);
    }
}
