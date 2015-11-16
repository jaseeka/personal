package com.personal.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.Page;
import com.personal.common.TypeEnum;
import com.personal.dao.ItemDao;
import com.personal.dao.PlanDao;
import com.personal.entity.Item;
import com.personal.entity.Plan;
import com.personal.service.IItemService;
import com.personal.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jaseeka
 * Date 2015/10/27
 * Time 22:34
 */
@Service
public class PlanService implements IPlanService {

    @Autowired
    private PlanDao planDao;
    @Autowired
    private IItemService itemService;

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @Override
    public Plan getById(Integer id){

        if (id == null || id <= 0){
            return null;
        }
        Plan reqPlan = new Plan();
        reqPlan.setId(id);

        return planDao.selectById(reqPlan);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(Integer id){
        if (id == null || id <= 0){
            return false;
        }
        Plan reqPlan = new Plan();
        reqPlan.setId(id);

        return planDao.deleteById(reqPlan) > 0 ? true : false;
    }

    /**
     * 添加（返回id）
     * @param obj
     * @return
     */
    @Override
    public Integer insert(Plan obj){

        if (obj == null){
            return 0;
        }

        Integer result = planDao.insert(obj);

        if (result > 0){
            return obj.getId();
        }else {
            return 0;
        }
    }

    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(Plan obj){
        if (obj == null){
            obj = new Plan();
        }
        return planDao.selectAndLikeCount(obj);
    }

    /**
     * 更新
     * @param obj
     * @return
     */
    @Override
    public Boolean update(Plan obj){
        if (obj == null || obj.getId() == null || obj.getId() <= 0){
            return false;
        }

        return planDao.update(obj) > 0 ? true : false;
    }

    /**
     * 获取列表
     * @param obj
     * @param page
     * @return
     */
    @Override
    public PageList<Plan> getList(Plan obj, Page page){
        if (obj == null){
            obj = new Plan();
        }
        if (page == null){
            page = new Page();
        }

        return planDao.selectAndLike(obj, page.gainPageBounds());
    }


    /**
     * 添加循环任务
     * @return
     */
    @Override
    public Boolean addCyclePlan(){
        PageList<Plan> planPageList = getList(null, null);
        if (planPageList == null || planPageList.size() <= 0){
            return false;
        }
        for (Plan plan : planPageList){
            if (plan.getIsCycle()){
                Item item = new Item();
                item.setIsDeleted(false);
                item.setState(TypeEnum.ItemState.NORMAL.ordinal());
                item.setTime(new Date());
                item.setContent(plan.getContent());
                itemService.insert(item);
            }
        }
        return true;
    }
}
