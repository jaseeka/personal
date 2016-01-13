package com.personal.service.impl;

import com.common.service.BaseService;
import com.common.utils.ClassUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.TypeEnum;
import com.personal.dao.PlanDao;
import com.personal.entity.Item;
import com.personal.entity.Plan;
import com.personal.service.IItemService;
import com.personal.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jaseeka
 * Date 2015/10/27
 * Time 22:34
 */
@Service
public class PlanService extends BaseService<Plan> implements IPlanService {

    @Resource
    private PlanDao planDao;
    @Resource
    private IItemService itemService;


    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(Plan obj){
        if (obj == null){
            obj = new Plan();
        }
        return this.getAndLikeCount(obj);
    }


    /**
     * 添加循环任务
     * @return
     */
    @Override
    public Boolean addCyclePlan(){
        PageList<Plan> planPageList = getListAnd(null, null);
        if (planPageList == null || planPageList.size() <= 0){
            return false;
        }
        Calendar date = Calendar.getInstance();
        Integer day = date.get(Calendar.DAY_OF_YEAR);
        for (Plan plan : planPageList){

            if (day % plan.getCycleNum() == 0) {
                Item item = new Item();
                item.setIsDeleted(false);
                item.setState(TypeEnum.ItemState.NORMAL.ordinal());
                item.setTime(new Date());
                item.setContent(plan.getContent());
                item.setUserId(plan.getUserId());
                itemService.add(item);
            }
        }
        return true;
    }
}
