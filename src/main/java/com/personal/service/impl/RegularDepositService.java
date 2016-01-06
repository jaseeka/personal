package com.personal.service.impl;

import com.common.common.Page;
import com.common.service.BaseService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.dao.RegularDepositDao;
import com.personal.entity.RegularDeposit;
import com.personal.service.IRegularDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jaseeka
 * Date 2015/11/16
 * Time 8:42
 */
@Service
public class RegularDepositService extends BaseService<RegularDeposit> implements IRegularDepositService {

    @Autowired
    private RegularDepositDao regularDepositDao;

    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(RegularDeposit obj){
        if (obj == null){
            obj = new RegularDeposit();
        }
        return this.getAndLikeCount(obj);
    }

    /**
     * 添加定存金额
     */
    @Override
    public boolean addCycleNum(){
        RegularDeposit reqRegularDeposit = new RegularDeposit();
        reqRegularDeposit.setIsDeleted(false);

        Page page = new Page(1,2, "id", Page.ORDER_DESC);

        PageList<RegularDeposit> regularDepositList = getListAnd(reqRegularDeposit, page);
        if (regularDepositList == null || regularDepositList.size() <= 0){
            return false;
        }

//        for (RegularDeposit regularDeposit : regularDepositList) {
        RegularDeposit regularDeposit1 = regularDepositList.get(1);
        regularDeposit1.setTime(new Date());
        regularDeposit1.setNumber(regularDeposit1.getNumber() + regularDeposit1.getCycleNum());
        add(regularDeposit1);
//        }

        RegularDeposit regularDeposit2 = regularDepositList.get(0);
        regularDeposit2.setTime(new Date());
        regularDeposit2.setNumber(regularDeposit2.getNumber() + regularDeposit2.getCycleNum());
        add(regularDeposit2);

        return true;
    }
}
