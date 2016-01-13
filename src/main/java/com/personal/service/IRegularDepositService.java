package com.personal.service;

import com.common.service.IBaseService;
import com.personal.entity.RegularDeposit;

/**
 * Created by jaseeka
 * Date 2015/11/16
 * Time 8:42
 */
public interface IRegularDepositService extends IBaseService {

    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(RegularDeposit obj);


    /**
     * 添加定存金额
     */
    public boolean addCycleMoney();
}
