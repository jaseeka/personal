package com.personal.service;

import com.common.service.IBaseService;
import com.personal.entity.Plan;

/**
 * Created by jaseeka
 * Date 2015/10/27
 * Time 22:34
 */
public interface IPlanService extends IBaseService {

    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(Plan obj);

    /**
     * 添加循环任务
     * @return
     */
    Boolean addCyclePlan();
}
