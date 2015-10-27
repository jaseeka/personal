package com.personal.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.Page;
import com.personal.entity.Item;
import com.personal.entity.Plan;

/**
 * Created by jaseeka
 * Date 2015/10/27
 * Time 22:34
 */
public interface IPlanService {
    /**
     * 根据id获取
     * @param id
     * @return
     */
    public Plan getById(Integer id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public Boolean deleteById(Integer id);

    /**
     * 添加（返回id）
     * @param obj
     * @return
     */
    public Integer insert(Plan obj);

    /**
     * 更新
     * @param obj
     * @return
     */
    public Boolean update(Plan obj);

    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(Plan obj);

    /**
     * 获取列表
     * @param obj
     * @param page
     * @return
     */
    public PageList<Plan> getList(Plan obj, Page page);
}
