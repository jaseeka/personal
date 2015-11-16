package com.personal.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.Page;
import com.personal.entity.RegularDeposit;

/**
 * Created by jaseeka
 * Date 2015/11/16
 * Time 8:42
 */
public interface IRegularDepositService {
    /**
     * 根据id获取
     * @param id
     * @return
     */
    public RegularDeposit getById(Integer id);

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
    public Integer insert(RegularDeposit obj);

    /**
     * 更新
     * @param obj
     * @return
     */
    public Boolean update(RegularDeposit obj);

    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(RegularDeposit obj);

    /**
     * 获取列表
     * @param obj
     * @param page
     * @return
     */
    public PageList<RegularDeposit> getList(RegularDeposit obj, Page page);

    /**
     * 添加定存金额
     */
    public boolean addCycleNum();
}
